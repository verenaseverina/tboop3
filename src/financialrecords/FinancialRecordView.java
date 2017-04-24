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
    this.setSize(width,height);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel controls = new JPanel();
    controls.setSize(200,500);
    controls.setBackground(Color.white);
    controls.setVisible(true);
    controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));

    JButton addIncomeButton = new JButton("Add Income");
    addIncomeButton.setBackground(Color.white);
    addIncomeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    controls.add(addIncomeButton);

    JButton addExpenseButton = new JButton("Add Income");
    addExpenseButton.setBackground(Color.white);
    addExpenseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    controls.add(addExpenseButton);

    JPanel table = new JPanel();
    table.setSize(550,400);
    table.setBackground(Color.black);
    table.setVisible(true);

    JPanel controlBar = new JPanel();
    controlBar.setSize(550, 100);
    controlBar.setBackground(Color.gray);
    controlBar.setVisible(true);
    controlBar.setLayout(new GridLayout(0,1));

    // nanti pake JScrollPane
    JTable allRecords = new JTable();


    // biar resizable pake JSplitPane
    JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlBar, table);
    splitPane1.setDividerSize(0);
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