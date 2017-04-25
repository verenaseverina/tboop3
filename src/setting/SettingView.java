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
  private JButton resetButton = new JButton("Reset All");
  private JLabel successLabel = new JLabel("Data has been reset successfully");

  public SettingView(){
    this.setLocationRelativeTo(null);
    this.setSize(450,300);
    this.setTitle("Settings");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel globalPanel = new JPanel();
    JPanel firstPanel = new JPanel();
    JPanel firstSubPanel1 = new JPanel();
    JPanel firstSubPanel2 = new JPanel();
    JPanel firstSubPanel3 = new JPanel();
    JPanel secondPanel = new JPanel();
    JLabel hintLabel = new JLabel("Hint            ");
    JLabel passwordLabel = new JLabel("Password");

    globalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    globalPanel.add(acceptButton);
    globalPanel.add(cancelButton);

    firstSubPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstSubPanel1.add(lockCheckBox);

    hint.setEditable(lockCheckBox.isSelected());
    firstSubPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstSubPanel2.add(hintLabel);
    firstSubPanel2.add(hint);

    userPassword.setEditable(lockCheckBox.isSelected());
    firstSubPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstSubPanel3.add(passwordLabel);
    firstSubPanel3.add(userPassword);

    //Second Panel Content
    successLabel.setVisible(false);
    secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    secondPanel.add(resetButton);
    secondPanel.add(successLabel);

    firstPanel.setLayout(new BoxLayout(firstPanel,BoxLayout.Y_AXIS));
    firstPanel.add(firstSubPanel1);
    firstPanel.add(firstSubPanel2);
    firstPanel.add(firstSubPanel3);
    firstPanel.add(Box.createVerticalStrut(100));
    tabs.add("Privacy",firstPanel);
    tabs.add("Data",secondPanel);

    this.add(tabs,BorderLayout.CENTER);
    this.add(globalPanel,BorderLayout.SOUTH);
  }

  void addListener(ActionListener listenToEvent) {
    lockCheckBox.addActionListener(listenToEvent);
    acceptButton.addActionListener(listenToEvent);
    cancelButton.addActionListener(listenToEvent);
    resetButton.addActionListener(listenToEvent);
  }

  JButton getOKButton() {
    return acceptButton;
  }

  JButton getCancelButton() {
    return cancelButton;
  }

  JButton getResetButton() {
    return resetButton;
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

  JLabel getSuccessLabel(){
    return successLabel;
  }
}
