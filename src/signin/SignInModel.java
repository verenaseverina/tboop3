package signin;

import parse.Parse;

import javax.xml.transform.TransformerException;

/**
 *
 * Kelas model untuk sign in.
 * Kelas SignInModel memiliki atribut String id apakah program dikunci,
 * String pass yang merupakan katakunci untuk membuka program,
 * String description yang menjelaskan katakunci
 *
 * @author Verena Severina
 * @author Winarto
 */
public class SignInModel {
  /**
   * Atribut String yang menyatakan apakah program dikunci.
   */
  private String id;
  /**
   * Atribut String yang menjadi katakunci untuk membuka program.
   */
  private String pass;
  /**
   * Atribut String yang mendeskripsikan katakunci.
   */
  private String description;
  /**
   * Atribut parse untuk mengupdate data
   */
  private Parse parser;
  /**
   * Menginisialisasi atribut dari SignInModel.
   */
  public SignInModel() {
    id = "0";
    pass = "";
    description = "";
  }

  /**
   * Constructor dengan parameter.
   * @param parser adalah parsing yang mengambil data dari file eksternal
   */
  public SignInModel(Parse parser) {
    this.parser = parser;
    id = parser.getPassword()[0];
    pass = parser.getPassword()[1];
    description = parser.getPassword()[2];
  }

  /**
   * Getter id.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * Getter pass.
   * @return pass
   */
  public String getPass() {
    return pass;
  }

  /**
   * Getter description.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Setter id.
   * @param idBool boolean berupa String yang menyatakan apakah program dikunci
   */
  public void setId(String idBool) {
    id = idBool;
  }

  /**
   * Setter pass.
   * @param passw String yang akan diassign sebagai pass
   */
  public void setPass(String passw) {
    pass = passw;
  }

  /**
   * Setter description.
   * @param desc String yang akan diassign sebagai description
   */
  public void setDescription(String desc) {
    description = desc;
  }

  /**
   * Mengecek apakah program dikunci.
   * @return boolean yang menyatakan apakah program dikunci
   */
  public boolean isLock() {
    return (Integer.getInteger(id) == 1);
  }

  /**
   * Prosedur untuk mengganti password.
   * @param id adalah String yang menunjukkan apakah program punya password atau tidak
   * @param pass adalah String kata kunci untuk mengunci program
   * @param desc adalah String yang menggambarkan kata kunci
   */
  public void changePassword(String id, String pass, String desc) {
    setId(id);
    setPass(pass);
    setDescription(desc);
  }

  /**
   * Method untuk update data global
   */
  public void saveState(){
    String[] pass = new String[3];
    pass[0] = id;
    pass[1] = this.pass;
    pass[2] = description;
    parser.setPassword(pass);
    try {
      parser.saveFile();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

}
