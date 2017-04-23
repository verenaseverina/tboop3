package signin;


import financialrecords.FinancialRecordView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by KUKUH BASUKI RAHMAT on 22-Apr-17.
 */

public class SignInView extends JFrame {
  private int width = 200;
  private int height = 150;
  private JLabel passwtxt = new JLabel("Password : ");
  private JTextField inputPassword = new JTextField();
  private JButton check = new JButton("OK");
  private StringBuffer txt = new StringBuffer("");
  private JLabel hint = new JLabel(txt.toString());

  public SignInView() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    passwtxt.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(passwtxt);

    inputPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(inputPassword);

    hint.setAlignmentX(Component.CENTER_ALIGNMENT);
    hint.setVisible(false);
    panel.add(hint);

    check.setBackground(Color.black);
    check.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(check);

  }

  void addCheckListener(ActionListener listenForCheckButton) {
    check.addActionListener(listenForCheckButton);
  }

  public void showAlert() {
    JFrame alertFr = new JFrame();
    JOptionPane.showMessageDialog(alertFr, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
  }

  public void closeWindow() {
    this.dispose();
  }

  public String getInputPassword() {
    return inputPassword.getText();
  }

  public void setTxt(String text) {
    txt.replace(0,txt.length()-1, text);
  }
}
