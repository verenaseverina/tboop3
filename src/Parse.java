
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
 * @author nim_13515091
 */

public class Parse {
  private ArrayList<Record> in;
  private ArrayList<Record> out;
  
  public static void main(String[] args) throws TransformerException {
    Parse x = new Parse();
    x.saveFile();
  }
  
  /**
   * Melakukan parsing untuk dipakai pada kelas lain.
   */
  public Parse() {
    try {
      in = new ArrayList<Record>();
      out = new ArrayList<Record>();
      File xmlFile = new File("src/buku.xml");
      DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = xmlBuilder.newDocumentBuilder();
      Document docRecord = docBuilder.parse(xmlFile);

      docRecord.getDocumentElement().normalize();

      NodeList recordListIn = docRecord.getElementsByTagName("recordin");
      NodeList recordListOut = docRecord.getElementsByTagName("recordout");
      for (int idx = 0; idx < recordListIn.getLength(); idx++) {
        Node isiRecordIn = recordListIn.item(idx);
        Node isiRecordOut = recordListOut.item(idx);
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
   */
  public void saveFile() throws TransformerConfigurationException, TransformerException {
    try {
      DocumentBuilderFactory newFile = DocumentBuilderFactory.newInstance();
      DocumentBuilder fileBuilder = newFile.newDocumentBuilder();

      Document recordDoc = fileBuilder.newDocument();
      Element rootRecord = recordDoc.createElement("buku");
      recordDoc.appendChild(rootRecord);

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
   * Mengembalikkan nilai in.
   * @return ArrayList
   */
  public ArrayList<Record> getIn(){
    return in;
  }
  
  /**
   * Mengembalikkan nilai out.
   * @return ArrayList
   */
  public ArrayList<Record> getOut(){
    return out;
  }
  
  /**
   * Mengupdate nilai in.
   * @param inTemp
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
   * Mengupdate nilai out.
   * @param outTemp
   */  
  public void setOut(ArrayList<Record> outTemp){
    for (int idx = 0; idx < out.size(); idx++) {
      out.remove(idx);
    }
    
    for (int idx = 0; idx < outTemp.size(); idx++) {
      out.add(outTemp.get(idx));
    }
  }
}
