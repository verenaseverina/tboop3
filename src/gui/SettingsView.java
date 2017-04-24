package gui;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends JDialog {
  //First Panel Content
  private JCheckBox lockCheckBox = new JCheckBox("Use Password");
  private JPasswordField userPassword = new JPasswordField(10);
  private JTabbedPane tabs = new JTabbedPane();

  public SettingsView(){
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setSize(450,200);
    this.setTitle("Settings");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    firstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstPanel.add(lockCheckBox);

    userPassword.setEditable(lockCheckBox.isSelected());
    firstPanel.add(userPassword);

    //Second Panel Content
    JLabel label = new JLabel("Coming soon!");
    secondPanel.add(label);

    tabs.add("Privacy",firstPanel);
    tabs.add("More",secondPanel);
    this.add(tabs);
  }
}
