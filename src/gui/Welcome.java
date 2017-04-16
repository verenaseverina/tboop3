package gui;

import javax.swing.*;

public class Welcome extends JPanel {
  public Welcome() {
    JFrame frame = new JFrame();
    String text = "Welcome to Monius, Money Genius!";
    JOptionPane.showMessageDialog(frame, text, "Welcome", JOptionPane.PLAIN_MESSAGE);
    frame.setSize(200,100);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
