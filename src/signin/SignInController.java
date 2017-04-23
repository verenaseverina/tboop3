package signin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kelas controller untuk sign in.
 * Kelas SignInController memiliki atribut SignInModel
 *
 * @author Adrian Hartarto
 * @author Winarto
 */
public class SignInController {
  /**
   * Atribut signin.SignInModel.
   */
  private SignInModel signInM;
  /**
   * Atribut signin.SignInView.
   */
  private SignInView signInV;

  /**
   * Ctor dari SignInController.
   * @param theView adalah SignInView yang akan di-assign
   * @param theModel adalah SignInModel yang akan di-assign
   */
  public SignInController(SignInView theView, SignInModel theModel) {
    signInM = theModel;
    signInV = theView;

    this.signInV.addCheckListener(new CheckListener());
  }

  class CheckListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      if (validatePassword(signInV.getInputPassword())) {
        signInV.closeWindow();
        // ini manggil windowsnya gimana
      } else {
        signInV.setTxt(signInM.getDescription());
        signInV.showAlert();
      }
    }
  }

  /**
   * Mengecek apakah program dikunci.
   * @return boolean yang menyatakan apakah program dikunci
   */
  public boolean isLock() {
    return (Integer.getInteger(signInM.getId())==1);
  }

  /**
   * Prosedur untuk mengganti password.
   * @param id adalah String yang menunjukkan apakah program punya password atau tidak
   * @param pass adalah String kata kunci untuk mengunci program
   * @param desc adalah String yang menggambarkan kata kunci
   */
  public void changePassword(String id, String pass, String desc) {
    signInM.setId(id);
    signInM.setPass(pass);
    signInM.setDescription(desc);
  }

  /**
   * Mengecek apakah password sesuai.
   * @param pass adalah String masukan yang akan dicocokan
   * @return boolean yang menyatakan apakah password yang dimasukan sesuai.
   */
  public boolean validatePassword(String pass) {
    return (pass.compareTo(signInM.getPass()) == 0);
  }
}
