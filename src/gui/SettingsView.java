package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsView extends JDialog {
  //First Panel Content
  private JCheckBox lockCheckBox = new JCheckBox("Use Password");
  private JPasswordField userPassword = new JPasswordField(10);
  private JTabbedPane tabs = new JTabbedPane();
  private JButton acceptButton = new JButton("OK");
  private JButton cancelButton = new JButton("Cancel");

  public SettingsView(){
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setSize(450,300);
    this.setTitle("Settings");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    //Ditambah action listener disini karena tidak perlu mengambil informasi dari model
    lockCheckBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        JCheckBox cb = (JCheckBox) event.getSource();
        userPassword.setEditable(cb.isSelected());
        if(!cb.isSelected())
          userPassword.setText("");
      }
    });

    JPanel globalPanel = new JPanel();
    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();

    globalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    globalPanel.add(acceptButton);
    globalPanel.add(cancelButton);

    firstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    firstPanel.add(lockCheckBox);

    userPassword.setEditable(lockCheckBox.isSelected());
    firstPanel.add(userPassword);

    //Second Panel Content
    JLabel label = new JLabel("Coming soon!");
    secondPanel.add(label);

    tabs.add("Privacy",firstPanel);
    tabs.add("More",secondPanel);

    this.add(tabs,BorderLayout.CENTER);
    this.add(globalPanel,BorderLayout.SOUTH);
  }
}
