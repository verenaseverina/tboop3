package setting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KUKUH BASUKI RAHMAT on 23-Apr-17.
 */
public class SettingView extends JDialog{
  //First Panel Content
  private JCheckBox lockCheckBox = new JCheckBox("Use Password");
  private JPasswordField userPassword = new JPasswordField(10);
  private JTextField hint = new JTextField(10);
  private JTabbedPane tabs = new JTabbedPane();
  private JButton acceptButton = new JButton("OK");
  private JButton cancelButton = new JButton("Cancel");

  public SettingView(){
    this.setLocationRelativeTo(null);
    this.setSize(450,300);
    this.setTitle("Settings");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel globalPanel = new JPanel();
    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    JLabel hintLabel = new JLabel("Hint");
    JLabel passwordLabel = new JLabel("Password");

    globalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    globalPanel.add(acceptButton);
    globalPanel.add(cancelButton);

    firstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstPanel.add(lockCheckBox);

    hint.setEditable(lockCheckBox.isSelected());
    firstPanel.add(hintLabel);
    firstPanel.add(hint);

    userPassword.setEditable(lockCheckBox.isSelected());
    firstPanel.add(passwordLabel);
    firstPanel.add(userPassword);

    //Second Panel Content
    JLabel label = new JLabel("Coming soon!");
    secondPanel.add(label);

    tabs.add("Privacy",firstPanel);
    tabs.add("More",secondPanel);

    this.add(tabs,BorderLayout.CENTER);
    this.add(globalPanel,BorderLayout.SOUTH);
  }

  void addListener(ActionListener listenToEvent) {
    lockCheckBox.addActionListener(listenToEvent);
    acceptButton.addActionListener(listenToEvent);
    cancelButton.addActionListener(listenToEvent);
  }

  JButton getButtonOK() {
    return acceptButton;
  }

  JButton getButtonCancel() {
    return cancelButton;
  }

  JCheckBox getCheckBoxLock() {
    return lockCheckBox;
  }

  JPasswordField getPasswordField() {
    return userPassword;
  }

  JTextField getHint(){
    return hint;
  }
}
