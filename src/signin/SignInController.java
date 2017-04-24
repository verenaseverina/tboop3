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
   * Mengecek apakah password sesuai.
   * @param pass adalah String masukan yang akan dicocokan
   * @return boolean yang menyatakan apakah password yang dimasukan sesuai.
   */
  public boolean validatePassword(String pass) {
    return (pass.compareTo(signInM.getPass()) == 0);
  }
}
