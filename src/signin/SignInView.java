package signin;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Kelas view untuk signin.
 * Kelas ini memiliki atribut integer untuk width dari frame,
 * integer untuk height dari frame, JLabel untuk pesan masukan password,
 * JPasswordField untuk menerima masukan password, JButton untuk menyetujui pengecekan,
 * JLabel untuk memberikan deskripsi
 *
 * @author Verena Severina
 * @author Kukuh B R
 * @author Winarto
 */
public class SignInView extends JFrame {
  /**
   * Integer untuk width dari frame.
   */
  private int width = 200;
  /**
   * Integer untuk height dari frame.
   */
  private int height = 150;
  /**
   * JLabel untuk pesan masukan password.
   */
  private JLabel passwtxt = new JLabel("Password : ");
  /**
   * JPasswordField untuk menerima masukan password.
   */
  private JPasswordField inputPassword = new JPasswordField();
  /**
   * JButton untuk menyetujui pengecekan.
   */
  private JButton check = new JButton("OK");
  /**
   * StringBuffer untuk masukan hint.
   */
  private StringBuffer txt = new StringBuffer("");
  /**
   * JLabel untuk memberikan deskripsi.
   */
  private JLabel hint = new JLabel(txt.toString());

  /**
   * Constructor SignInView.
   */
  public SignInView() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setSize(width,height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    this.add(panel);
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenForCheckButton parameter untuk cek apakah terdapat Event
   */
  void addCheckListener(ActionListener listenForCheckButton) {
    check.addActionListener(listenForCheckButton);
  }

  /**
   * Prosedur untuk menampilkan pesan kesalahan.
   */
  public void showAlert() {
    JFrame alertFr = new JFrame();
    JOptionPane.showMessageDialog(alertFr, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Method untuk menutup Frame.
   */
  public void closeWindow() {
    this.dispose();
  }

  /**
   * Getter inputPassword.
   * @return inputPassword
   */
  public String getInputPassword() {
    return inputPassword.getText();
  }

  /**
   * Setter hint.
   * @param text adalah hint yang akan dimunculkan
   */
  public void setTxt(String text) {
    txt.replace(0,txt.length()-1, text);
  }
}
