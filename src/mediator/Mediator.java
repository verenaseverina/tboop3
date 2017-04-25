package mediator;

import financialrecords.FinancialRecordController;
import parse.Parse;
import setting.SettingController;
import signin.SignInController;

/**
 * Created by Winarto on 04/25/2017.
 */
public class Mediator {
  private FinancialRecordController frControl;
  private SettingController settingControl;
  private SignInController signInControl;
  private Parse parser;

  public Mediator() {
    parser = new Parse();
    //frControl = new FinancialRecordController();
    signInControl = new SignInController(this,parser);
    settingControl = new SettingController(this);
  }

  /**
   * Prosedur untuk mengambil id signin
   */
  public String getSignInID() {
    return signInControl.getSignInID();
  }

  /**
   * Prosedur untuk mengambil password signin
   */
  public String getSignInPass() {
    return signInControl.getSignInPass();
  }

  /**
   * Prosedur untuk mengambil deskripsi password
   */
  public String getSignInDesc() {
    return signInControl.getSignInDesc();
  }

  /**
   * Menyimpan informasi signin
   * @param id Status dikunci atau tidak
   * @param pass Password untuk membuka aplikasi
   * @param desc Hint yang digunakan pengguna
   */
  public void saveSignInState(String id, String pass, String desc) {
    signInControl.changePassword(id,pass,desc);
  }

  public void setSettingVisible(boolean state) {
    settingControl.visible(state);
  }

  public void setSignInVisible(boolean state){
    signInControl.visible(state);
  }
}
