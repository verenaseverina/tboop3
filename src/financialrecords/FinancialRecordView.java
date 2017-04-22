package financialrecords;

import java.awt.*;
import javax.swing.*;

public class FinancialRecordView extends JFrame {
  // bisa tambahin ga dia lagi nampilin apaan
  private int width = 750;
  private int height = 500;

  public FinancialRecordView() {
    this.setVisible(true);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel controls = new JPanel();
    controls.setSize(200,500);
    controls.setBackground(Color.white);
    controls.setVisible(true);
    controls.setLayout(null); // ini ntar ganti aja kalo ga suka layoutnya

    JButton addIncomeButton = new JButton("Add Income");
    addIncomeButton.setBackground(Color.black);
    addIncomeButton.setBounds(90,50,220,30); // ini harus ubah2 lagi

    JButton addOutcomeButton = new JButton("Add outcome");
    addOutcomeButton.setBackground(Color.black);
    addIncomeButton.setBounds(90,80,220,30); // ini harus ubah2 lagi

    JPanel glass = new JPanel();
    glass.setSize(550,500);
    glass.setBackground(Color.black);
    glass.setVisible(true);

    // biar resizable pake JSplitPane
    JSplitPane splitPane = new JSplitPane();
    splitPane.setSize(width,height);
    splitPane.setDividerSize(0);
    splitPane.setDividerLocation(200);
    splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
    splitPane.setLeftComponent(controls);
    splitPane.setRightComponent(glass);

    this.add(splitPane);
  }
}