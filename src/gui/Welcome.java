package gui;

import javax.swing.*;

/**
 * Kelas untuk menampilkan pesan welcome.
 *
 * @author Verena Severina
 * @author Kukuh B R
 */
public class Welcome extends JPanel {
  /**
   * Constructor Welcome.
   */
  public Welcome() {
    JFrame frame = new JFrame();
    String text = "Welcome to Monius, Money Genius!";
    JOptionPane.showMessageDialog(frame, text, "Welcome", JOptionPane.PLAIN_MESSAGE);
  }
}
