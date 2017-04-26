import gui.Welcome;
import mediator.Mediator;
import parse.ParseExc;
import setting.SettingController;
import setting.SettingView;

/**
 * Created by KUKUH BASUKI RAHMAT on 23-Apr-17.
 */
public class Main {
  public static void main(String args[]) throws ParseExc {
    Mediator med = new Mediator();
    med.setFrControlVisible(false);
    med.setSignInVisible(true);
    med.setSettingVisible(false);
  }
}
