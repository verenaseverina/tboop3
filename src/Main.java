import gui.Welcome;
import mediator.Mediator;
import setting.SettingController;
import setting.SettingView;
import signin.MvcSignIn;

/**
 * Created by KUKUH BASUKI RAHMAT on 23-Apr-17.
 */
public class Main {
  public static void main(String args[]) {
    Mediator med = new Mediator();
    med.setSignInVisible(false);
    med.setSettingVisible(true);
  }
}
