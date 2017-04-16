package gui;

import javax.swing.*;

public class Welcome extends JPanel {
  private static void introductionPanel() {
    JFrame frame = new JFrame();
    String text = "Welcome to Monius, Money Genius!";
    JOptionPane.showMessageDialog(frame, text, "Welcome", JOptionPane.PLAIN_MESSAGE);
  }
}
