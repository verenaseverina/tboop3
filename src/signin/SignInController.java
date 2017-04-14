package signin;

import parse.Parse;

/**
 * Kelas controller untuk sign in.
 * Kelas SignInController memiliki atribut SignInModel
 *
 * @author Adrian Hartanto
 * @author Winarto
 */
public class SignInController {
  /**
   * Atribut signin.SignInModel.
   */
  private SignInModel signIn;

  /**
   * Ctor dari SignInController.
   * @param parser adalah kelas untuk melakukan parsing
   */
  public SignInController(Parse parser) {
    signIn.setId(parser.getPassword()[0]);
    signIn.setPass(parser.getPassword()[1]);
    signIn.setDescription(parser.getPassword()[2]);
  }

  /**
   * Mengecek apakah program dikunci.
   * @return boolean yang menyatakan apakah program dikunci
   */
  public boolean isLock() {
    return (Integer.getInteger(signIn.getId())==1);
  }

  /**
   * Prosedur untuk mengganti password.
   * @param id adalah String yang menunjukkan apakah program punya password atau tidak
   * @param pass adalah String kata kunci untuk mengunci program
   * @param desc adalah String yang menggambarkan kata kunci
   */
  public void changePassword(String id, String pass, String desc) {
    signIn.setId(id);
    signIn.setPass(pass);
    signIn.setDescription(desc);
  }

  /**
   * Mengecek apakah password sesuai.
   * @param pass adalah String masukan yang akan dicocokan
   * @return boolean yang menyatakan apakah password yang dimasukan sesuai.
   */
  public boolean validatePassword(String pass) {
    return (pass.compareTo(signIn.getPass()) == 0);
  }
}
