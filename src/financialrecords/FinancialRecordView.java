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

    JButton addOutcomeButton = new JButton("Add Income");
    addOutcomeButton.setBackground(Color.black);
    addOutcomeButton.setBounds(90,80,220,30); // ini harus ubah2 lagi

    JPanel table = new JPanel();
    table.setSize(550,450);
    table.setBackground(Color.black);
    table.setVisible(true);

    JPanel controlBar = new JPanel();
    controlBar.setSize(550, 50);
    controlBar.setBackground(Color.gray);
    controlBar.setVisible(true);

    // nanti pake JScrollPane
    JTable table = new JTable();


    // biar resizable pake JSplitPane
    JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlBar, table);
    JSplitPane splitPane2 = new JSplitPane();
    splitPane2.setSize(width,height);
    splitPane2.setDividerSize(0);
    splitPane2.setDividerLocation(200);
    splitPane2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
    splitPane2.setLeftComponent(controls);
    splitPane2.setRightComponent(splitPane1);
    
    this.add(splitPane2);


  }
}