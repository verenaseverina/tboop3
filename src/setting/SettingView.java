package setting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kelas view untuk setting.
 * Kelas SettingView memiliki atribut JCheckBox untuk menunjukkan apakah program dikunci,
 * JPasswordField untuk menerima masukan password dari user,
 * JTextField yang berisi deskripsi dari password,
 * JTextField yang menunjukkan banyaknya tabungan yang ingin dicapai user,
 * JTabbedPane untuk membuat tab pilihan,
 * JButton untuk menerima, JButton untuk membatalkan, JButton untuk menghapus semua data,
 * JButton untuk mengembalikan setting ke Default, JLabel untuk pesan berhasil,
 * dan JLabel untuk pesan gagal
 */
public class SettingView extends JDialog{
  /**
   * JCheckBox untuk menunjukkan apakah program dikunci.
   */
  private JCheckBox lockCheckBox = new JCheckBox("Use Password");
  /**
   * JPasswordField untuk menerima masukan password dari user.
   */
  private JPasswordField userPassword = new JPasswordField(10);
  /**
   * JTextField yang berisi deskripsi dari password.
   */
  private JTextField hint = new JTextField(10);
  /**
   * JTextField yang menunjukkan banyaknya tabungan yang ingin dicapai user.
   */
  private JTextField savings = new JTextField(10);
  /**
   * JTabbedPane untuk membuat tab pilihan.
   */
  private JTabbedPane tabs = new JTabbedPane();
  /**
   * JButton untuk menerima.
   */
  private JButton acceptButton = new JButton("OK");
  /**
   * JButton untuk membatalkan.
   */
  private JButton cancelButton = new JButton("Cancel");
  /**
   * JButton untuk mengembalikan setting ke Default.
   */
  private JButton resetButton = new JButton("Default");
  /**
   * JButton untuk menghapus semua data.
   */
  private JButton deleteButton = new JButton("Delete Data");
  /**
   * JLabel untuk pesan berhasil.
   */
  private JLabel successLabel = new JLabel("Setting has been set to default");
  /**
   * JLabel untuk pesan gagal.
   */
  private JLabel deleteLabel = new JLabel("Data has been deleted successfully");

  /**
   * Constructor SettingView.
   */
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
    JPanel secondSubPanel1 = new JPanel();
    JPanel secondSubPanel2 = new JPanel();
    JPanel secondSubPanel3 = new JPanel();
    JLabel hintLabel = new JLabel("Hint            ");
    JLabel passwordLabel = new JLabel("Password");
    JLabel savingLabel = new JLabel("Jumlah yang ingin ditabung");

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
    secondSubPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
    secondSubPanel1.add(savingLabel);
    secondSubPanel1.add(savings);

    successLabel.setVisible(false);
    secondSubPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
    secondSubPanel2.add(resetButton);
    secondSubPanel2.add(successLabel);

    deleteLabel.setVisible(false);
    secondSubPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
    secondSubPanel3.add(deleteButton);
    secondSubPanel3.add(deleteLabel);

    firstPanel.setLayout(new BoxLayout(firstPanel,BoxLayout.Y_AXIS));
    firstPanel.add(firstSubPanel1);
    firstPanel.add(firstSubPanel2);
    firstPanel.add(firstSubPanel3);
    firstPanel.add(Box.createVerticalStrut(100));

    secondPanel.setLayout(new BoxLayout(secondPanel,BoxLayout.Y_AXIS));
    secondPanel.add(secondSubPanel1);
    secondPanel.add(secondSubPanel2);
    secondPanel.add(secondSubPanel3);
    secondPanel.add(Box.createVerticalStrut(100));
    tabs.add("Privacy",firstPanel);
    tabs.add("Data",secondPanel);

    this.add(tabs,BorderLayout.CENTER);
    this.add(globalPanel,BorderLayout.SOUTH);
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenToEvent parameter untuk cek apakah terdapat Event
   */
  void addListener(ActionListener listenToEvent) {
    lockCheckBox.addActionListener(listenToEvent);
    acceptButton.addActionListener(listenToEvent);
    cancelButton.addActionListener(listenToEvent);
    resetButton.addActionListener(listenToEvent);
    deleteButton.addActionListener(listenToEvent);
  }

  /**
   * Getter acceptButton.
   * @return acceptButton
   */
  JButton getOKButton() {
    return acceptButton;
  }

  /**
   * Getter cancelButton.
   * @return cancelButton
   */
  JButton getCancelButton() {
    return cancelButton;
  }

  /**
   * Getter resetButton.
   * @return resetButton
   */
  JButton getResetButton() {
    return resetButton;
  }

  /**
   * Getter deleteButton.
   * @return deleteButton
   */
  JButton getDeleteButton(){
    return deleteButton;
  }

  /**
   * Getter CheckBox lockCheckBox.
   * @return CheckBox lockCheckBox
   */
  JCheckBox getCheckBoxLock() {
    return lockCheckBox;
  }

  /**
   * Getter userPassword.
   * @return userPassword
   */
  JPasswordField getPasswordField() {
    return userPassword;
  }

  /**
   * Getter TextField hint.
   * @return TextField hint
   */
  JTextField getHint(){
    return hint;
  }

  /**
   * Getter TextField savings.
   * @return TextField savings
   */
  JTextField getSavings(){
    return savings;
  }

  /**
   * Getter successLabel.
   * @return successLabel
   */
  JLabel getSuccessLabel(){
    return successLabel;
  }

  /**
   * Getter deleteLabel.
   * @return deleteLabel
   */
  JLabel getDeleteLabel(){
    return deleteLabel;
  }
}
