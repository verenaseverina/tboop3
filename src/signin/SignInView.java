package signin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KUKUH BASUKI RAHMAT on 22-Apr-17.
 */

public class SignInView extends JFrame {
  private int width =  200;
  private int height = 150;
  private SignInController signIn;

  public SignInView() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

    JLabel passwtxt = new JLabel("Password : ");
    passwtxt.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(passwtxt);

    JTextField inputPassword = new JTextField();
    inputPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(inputPassword);

    JButton check = new JButton("OK");
    check.setBackground(Color.black);
    check.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(check);

    check.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                String inPass = new String(inputPassword.getText());
                if (signIn.validatePassword(inPass)) {

                } else {
                  
                }
              }
            }
    );
  }
}
