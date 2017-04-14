
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * Kelas yang membaca dan menulis file eksternal.
 * Kelas parse memiliki atribut array list data pemasukkan dan
 * array list data pengeluaran, selain itu ada atribut array of string
 * yang berisi password
 * 
 * @author Winarto
 * @author Adrian Hartarto
 */
public class Parse {
  /**
   * Atribut array list of Record dari Parse (data pemasukkan).
   */
  private ArrayList<Record> in;
  /**
   * Atribut array list of Record dari Parse (data pengeluaran).
   */
  private ArrayList<Record> out;
  /**
   * Atribut array of String dari Parse (Password).
   */
  private String[] password;
  
  public static void main(String[] args) throws TransformerException {
    Parse x = new Parse();
    x.saveFile();
  }
  
  /**
   * Melakukan parsing untuk dipakai pada kelas lain.
   */
  public Parse() {
    try {
      in = new ArrayList<>();
      out = new ArrayList<>();
      password = new String[3];
      File xmlFile = new File("src/buku.xml");
      DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = xmlBuilder.newDocumentBuilder();
      Document docRecord = docBuilder.parse(xmlFile);

      docRecord.getDocumentElement().normalize();

      NodeList recordListIn = docRecord.getElementsByTagName("recordin");
      NodeList recordListOut = docRecord.getElementsByTagName("recordout");
      NodeList lock = docRecord.getElementsByTagName("lock");
      for (int idx = 0; idx < recordListIn.getLength(); idx++) {
        Node isiLock = lock.item(idx);
        Node isiRecordIn = recordListIn.item(idx);
        Node isiRecordOut = recordListOut.item(idx);
        if (isiLock.getNodeType() == Node.ELEMENT_NODE) {
          Element elRecord = (Element) isiLock;
          password[0] = elRecord.getAttribute("id");
          password[1] = elRecord.getElementsByTagName("password").item(0).getTextContent();
          password[2] = elRecord.getElementsByTagName("deskripsi").item(0).getTextContent();
        }
        if (isiRecordIn.getNodeType() == Node.ELEMENT_NODE) {
          Element elRecord = (Element) isiRecordIn;
          String tanggal = elRecord.getElementsByTagName("tanggal").item(0).getTextContent();
          String jumlah = elRecord.getElementsByTagName("jumlah").item(0).getTextContent();
          String deskripsi = elRecord.getElementsByTagName("deskripsi").item(0).getTextContent();
          String kategori = elRecord.getElementsByTagName("kategori").item(0).getTextContent();
          Record pemasukkan = new Record(tanggal, jumlah, deskripsi, kategori);
          in.add(pemasukkan);
        }
        if (isiRecordOut.getNodeType() == Node.ELEMENT_NODE) {
          Element elRecord = (Element) isiRecordOut;
          String tanggal = elRecord.getElementsByTagName("tanggal").item(0).getTextContent();
          String jumlah = elRecord.getElementsByTagName("jumlah").item(0).getTextContent();
          String deskripsi = elRecord.getElementsByTagName("deskripsi").item(0).getTextContent();
          Record pengeluaran = new Record(tanggal, jumlah, deskripsi);
          out.add(pengeluaran);
        }
      }      
    } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
    }
  }
  
  /**
   * Menyimpan data ke file eksternal.
   * @throws javax.xml.transform.TransformerConfigurationException
   */
  public void saveFile() throws TransformerConfigurationException, TransformerException {
    try {
      DocumentBuilderFactory newFile = DocumentBuilderFactory.newInstance();
      DocumentBuilder fileBuilder = newFile.newDocumentBuilder();

      Document recordDoc = fileBuilder.newDocument();
      Element rootRecord = recordDoc.createElement("buku");
      recordDoc.appendChild(rootRecord);
      
      Element lock = recordDoc.createElement("lock");
      rootRecord.appendChild(lock);
      
      Attr idTrue = recordDoc.createAttribute("id");
      idTrue.setValue(password[0]);
      lock.setAttributeNode(idTrue);
      
      Element pass = recordDoc.createElement("password");
      pass.appendChild(recordDoc.createTextNode(password[1]));
      lock.appendChild(pass);
      
      Element desc = recordDoc.createElement("deskripsi");
      desc.appendChild(recordDoc.createTextNode(password[2]));
      lock.appendChild(desc);

      for (Record recIn : in) {
        Element recordin = recordDoc.createElement("recordin");
        rootRecord.appendChild(recordin);

        Attr idPrimeKey = recordDoc.createAttribute("id");
        idPrimeKey.setValue(Integer.toString(recIn.hashCode()));
        recordin.setAttributeNode(idPrimeKey);

        Element tanggal = recordDoc.createElement("tanggal");
        tanggal.appendChild(recordDoc.createTextNode(recIn.getDate()));
        recordin.appendChild(tanggal);

        Element jumlah = recordDoc.createElement("jumlah");
        jumlah.appendChild(recordDoc.createTextNode(Long.toString(recIn.getAmount())));
        recordin.appendChild(jumlah);

        Element deskripsi = recordDoc.createElement("deskripsi");
        deskripsi.appendChild(recordDoc.createTextNode(recIn.getDescription()));
        recordin.appendChild(deskripsi);

        Element kategori = recordDoc.createElement("kategori");
        kategori.appendChild(recordDoc.createTextNode(recIn.getCategory()));
        recordin.appendChild(kategori);
      }
      
      for (Record recOut : out) {
        Element recordout = recordDoc.createElement("recordout");
        rootRecord.appendChild(recordout);

        Attr idPrimeKey = recordDoc.createAttribute("id");
        idPrimeKey.setValue(Integer.toString(recOut.hashCode()));
        recordout.setAttributeNode(idPrimeKey);

        Element tanggal = recordDoc.createElement("tanggal");
        tanggal.appendChild(recordDoc.createTextNode(recOut.getDate()));
        recordout.appendChild(tanggal);

        Element jumlah = recordDoc.createElement("jumlah");
        jumlah.appendChild(recordDoc.createTextNode(Long.toString(recOut.getAmount())));
        recordout.appendChild(jumlah);

        Element deskripsi = recordDoc.createElement("deskripsi");
        deskripsi.appendChild(recordDoc.createTextNode(recOut.getDescription()));
        recordout.appendChild(deskripsi);
      }
      
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT,"yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      DOMSource source = new DOMSource(recordDoc);
      StreamResult result = new StreamResult(new File("src/cek.xml"));

      transformer.transform(source, result);
    } catch (ParserConfigurationException | TransformerException pce) {
    }
  }
  
  /**
   * Getter in.
   * @return in
   */
  public ArrayList<Record> getIn(){
    return in;
  }
  
  /**
   * Getter out.
   * @return out
   */
  public ArrayList<Record> getOut(){
    return out;
  }
  
  /**
   * Getter password.
   * @return password
   */
  public String[] getPassword(){
    return password;
  }
  
  /**
   * Setter in.
   * @param inTemp array list yang ingin disimpan
   */  
  public void setIn(ArrayList<Record> inTemp){
    for (int idx = 0; idx < in.size(); idx++) {
      in.remove(idx);
    }
    
    for (int idx = 0; idx < inTemp.size(); idx++) {
      in.add(inTemp.get(idx));
    }
  }
  
  /**
   * Setter out.
   * @param outTemp array list yang ingin disimpan
   */  
  public void setOut(ArrayList<Record> outTemp){
    for (int idx = 0; idx < out.size(); idx++) {
      out.remove(idx);
    }
    
    for (int idx = 0; idx < outTemp.size(); idx++) {
      out.add(outTemp.get(idx));
    }
  }
  
  /**
   * Setter password.
   * @param pass array of String yang ingin disimpan
   */  
  public void setPassword(String[] pass){
    password[0] = pass[0];
    password[1] = pass[1];
    password[2] = pass[2];
  }
}