package setting;

import mediator.Mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kelas controller untuk setting.
 * Kelas SettingController memiliki atribut SettingView
 *
 * @author ..
 * @author ..
 */
public class SettingController {
  /**
   * Atribut mediator
   */
  private Mediator med;
  /**
   * Atribut setting.SettingView.
   */
  private SettingView settingV;

  /**
   * Ctor dari SettingController.
   * @param _med mediator antar controller
   */
  public SettingController(Mediator _med) {
    med = _med;
    if(settingV == null)
      settingV = new SettingView();

    settingV.setVisible(true);
    settingV.getCheckBoxLock().setSelected(med.getSignInID().equals("1"));
    if(settingV.getCheckBoxLock().isSelected()) {
      settingV.getHint().setEditable(true);
      settingV.getPasswordField().setEditable(true);
      settingV.getHint().setText(med.getSignInDesc());
      settingV.getPasswordField().setText(med.getSignInPass());
      settingV.getSavings().setText(Long.toString(med.getSavings()));
    }
    settingV.addListener(new CheckListener());
  }

  /**
   * Menampilkan atau menyembunyikan tampilan SettingView
   */
  public void visible(boolean state) {
    settingV.setVisible(state);
  }

  class CheckListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if(event.getSource() == settingV.getOKButton()){
        int lockState = settingV.getCheckBoxLock().isSelected() ? 1 : 0;
        med.saveSignInState(Integer.toString(lockState),settingV.getPasswordField().getText(),settingV.getHint().getText());
        if(settingV.getSavings().getText().equals("") || Integer.parseInt(settingV.getSavings().getText()) < 0)
          med.saveSavings(0);
        else
          med.saveSavings(Integer.parseInt(settingV.getSavings().getText()));
        settingV.dispose();
      } else if (event.getSource() == settingV.getCancelButton()) {
        settingV.dispose();
      } else if (event.getSource() == settingV.getCheckBoxLock()) {
        settingV.getPasswordField().setEditable(settingV.getCheckBoxLock().isSelected());
        settingV.getHint().setEditable(settingV.getCheckBoxLock().isSelected());
        if(!settingV.getCheckBoxLock().isSelected()) {
          settingV.getPasswordField().setText("");
          settingV.getHint().setText("");
        } else {
          settingV.getPasswordField().setText(med.getSignInPass());
          settingV.getHint().setText(med.getSignInDesc());
        }
      } else if(event.getSource() == settingV.getResetButton()) {
        settingV.getSuccessLabel().setVisible(true);
        settingV.getCheckBoxLock().setSelected(false);
        settingV.getPasswordField().setEditable(settingV.getCheckBoxLock().isSelected());
        settingV.getHint().setEditable(settingV.getCheckBoxLock().isSelected());
        settingV.getHint().setText("");
        settingV.getPasswordField().setText("");
        settingV.getSavings().setText("");
      } else if(event.getSource() == settingV.getDeleteButton()) {
        settingV.getDeleteLabel().setVisible(true);
        med.deleteInOut();
      }
    }
  }
}
