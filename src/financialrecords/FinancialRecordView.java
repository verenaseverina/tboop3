package financialrecords;

import financialrecords.records.Record;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class FinancialRecordView extends JFrame {
  // bisa tambahin ga dia lagi nampilin apaan
  private int width = 750;
  private int height = 500;
  private JTable finaltable;
  private JButton addIncomeButton = new JButton(" Add Income ");
  private JButton addExpenseButton = new JButton("Add Expense");
  private JButton addUpdateButton = new JButton("Update Record");
  private JButton addDeleteButton = new JButton("Delete Record");
  private JButton thisWeek = new JButton("This Week");
  private JButton thisMonth = new JButton("This Month");
  private JButton thisYear = new JButton("This Year");

  public FinancialRecordView(final FinancialRecordModel frmodel) {
    this.setVisible(true);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setSize(width,height);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel controls = new JPanel();
    controls.setSize(200,500);
    controls.setBackground(Color.white);
    controls.setVisible(true);
    controls.setLayout(new GridLayout(0,1));

    addIncomeButton.setBackground(Color.white);
    addIncomeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addIncomeButton);

    addExpenseButton.setBackground(Color.white);
    addExpenseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addExpenseButton);

    addUpdateButton.setBackground(Color.white);
    addUpdateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addUpdateButton);

    addDeleteButton.setBackground(Color.white);
    addDeleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addDeleteButton);
    
    JPanel table = new JPanel();
    table.setLayout(new BorderLayout());
    table.setSize(550,400);
    table.setBackground(Color.white);
    table.setVisible(true);
    setTableRecord(frmodel);
    table.add(finaltable);
    JScrollPane tableContainer = new JScrollPane(table);

    JPanel controlBar = new JPanel();
    controlBar.setSize(550, 100);
    controlBar.setBackground(Color.gray);
    controlBar.setVisible(true);
    controlBar.setLayout(new GridLayout(1,0));

    thisWeek.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(thisWeek);

    thisMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(thisMonth);

    thisYear.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(thisYear);

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
  
  public void setTableRecord(final FinancialRecordModel frmodel) {

    
    String[] column = {"Expense/Income", "tanggal","jumlah","deskripsi","kategori"};
    Object[][] objData = new Object[frmodel.getExpense().size()+frmodel.getIncome().size()][5];

    int idx = 0;
    for(Record itrExp : frmodel.getExpense()){
        String[] arrData = {"Expense", itrExp.getDate().dateToStr(), Long.toString(itrExp.getAmount()), itrExp.getDescription(), itrExp.getCategory()};
        objData[idx] = arrData;
        idx++;
    }
    
    for(Record itrExp : frmodel.getIncome()){
        String[] arrData = {"Income",itrExp.getDate().dateToStr(), Long.toString(itrExp.getAmount()), itrExp.getDescription(), itrExp.getCategory()};
        objData[idx] = arrData;
        idx++;
    }

    DefaultTableModel tabModel = new DefaultTableModel(objData,column){
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
        }
    };
    
    finaltable = new JTable();
    finaltable.setModel(tabModel);
  }

  void addIncomeButtonListener(ActionListener listenForAddIncomeButton) {
    addIncomeButton.addActionListener(listenForAddIncomeButton);
  }

  void addExpenseButtonListener(ActionListener listenForAddExpenseButton) {
    addExpenseButton.addActionListener(listenForAddExpenseButton);
  }

  void addUpdateButtonListener(ActionListener listenForAddUpdateButton) {
    addUpdateButton.addActionListener(listenForAddUpdateButton);
  }

  void addDeleteButtonListener(ActionListener listenForAddDeleteButton) {
    addDeleteButton.addActionListener(listenForAddDeleteButton);
  }

  void addThisWeekListener(ActionListener listenForAddThisWeekButton) {
    thisWeek.addActionListener(listenForAddThisWeekButton);
  }

  void addThisMonthListener(ActionListener listenForAddThisMonthButton) {
    thisMonth.addActionListener(listenForAddThisMonthButton);
  }

  void addThisYearListener(ActionListener listenForAddThisYearButton) {
    thisYear.addActionListener(listenForAddThisYearButton);
  }
}