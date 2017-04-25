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
    settingControl = new SettingController(this);
    signInControl = new SignInController(this,parser);
  }

  public void saveSignInState(String id, String pass, String desc) {
    signInControl.changePassword(id,pass,desc);
  }

  public void showSetting(boolean state) {
    settingControl.visible(state);
  }

  public void showSignIn(boolean state){
    signInControl.visible(state);
  }
}
