package signin;

import mediator.Mediator;
import parse.Parse;

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
   * Atribut mediator
   */
  private Mediator med;
  /**
   * Atribut signin.SignInModel.
   */
  private SignInModel signInM;
  /**
   * Atribut signin.SignInView.
   */
  private SignInView signInV;

  /**
   * Ctor dari SignInController tanpa parameter.
   */
  public SignInController() {
    signInM = new SignInModel();
    signInV = new SignInView();
  }

  /**
   * Ctor dari SignInController.
   * @param _med mediator antar controller
   */
  public SignInController(Mediator _med, Parse parser) {
    signInM = new SignInModel(parser);
    signInV = new SignInView();
    med = _med;
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

  /**
   * Menampilkan atau menyembunyikan tampilan SignInView
   */
  public void visible(boolean state){
    signInV.setVisible(state);
  }

  /**
   * Prosedur untuk mengganti password.
   * @param id adalah String yang menunjukkan apakah program punya password atau tidak
   * @param pass adalah String kata kunci untuk mengunci program
   * @param desc adalah String yang menggambarkan kata kunci
   */
  public void changePassword(String id, String pass, String desc){
    signInM.changePassword(id,pass,desc);
    signInM.saveState();
  }

  /**
   * Prosedur untuk mengambil id signin
   */
  public String getSignInID() {
    return signInM.getId();
  }

  /**
   * Prosedur untuk mengambil password signin
   */
  public String getSignInPass() {
    return signInM.getPass();
  }

  /**
   * Prosedur untuk mengambil deskripsi password
   */
  public String getSignInDesc() {
    return signInM.getDescription();
  }
}
