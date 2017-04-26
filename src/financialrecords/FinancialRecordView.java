package financialrecords;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import dateformat.DateLabelFormatter;
import financialrecords.records.Record;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DateFormatter;

/**
 * Kelas view untuk FinancialRecord.
 * Kelas ini memiliki atribut integer untuk width frame, integer untuk height frame,
 * JTable untuk tabel yang berisi Record, JButton untuk menambah Record Income,
 * JButton untuk menambah Record Expense, JTextField untuk mengisi amount,
 * String untuk menghasilkan hasil pemilihan JComboBox,
 * JTextField untuk mengisi description, JButton untuk melakukan update,
 * JButton untuk melakukan penghapusan Record,
 * JButton untuk memilih hanya menampilkan satu minggu tabel,
 * JButton untuk memilih hanya menampilkan satu bulan tabel,
 * JButton untuk memilih hanya menampilkan satu tahun tabel,
 *
 *
 * @author Winarto
 * @author Adrian Hartarto
 */
public final class FinancialRecordView extends JFrame {
  /**
   * Atribut integer untuk width frame.
   */
  private int width = 750;
  /**
   * Atribut integer untuk height frame.
   */
  private int height = 500;
  /**
   * Atribut JTable untuk tabel yang berisi Record.
   */
  private JTable finaltable;
  /**
   * Atribut JButton untuk menambah Record Income.
   */
  private JButton addIncButton = new JButton(" Add Income ");
  /**
   * Atribut JButton untuk menambah Record Expense.
   */
  private JButton addExpButton = new JButton("Add Expense");
  /**
   * Atribut JTextField untuk mengisi amount.
   */
  private JTextField amountTextField = new JTextField();
  /**
   * Atribut String untuk menghasilkan hasil pemilihan JComboBox.
   */
  private String selection;
  /**
   * Atribut JTextField untuk mengisi description.
   */
  private JTextField descriptionTextField = new JTextField();
  /**
   * Atribut JButton untuk melakukan update.
   */
  private JButton addUpdateButton = new JButton("Update Record");
  /**
   * Atribut JButton untuk melakukan penghapusan Record.
   */
  private JButton addDeleteButton = new JButton("Delete Record");
  /**
   * Atribut JButton untuk memilih hanya menampilkan satu minggu tabel.
   */
  private JButton today = new JButton("Today");
  /**
   * Atribut JButton untuk memilih hanya menampilkan satu bulan tabel.
   */
  private JButton thisMonth = new JButton("This Month");
  /**
   * Atribut JButton untuk memilih hanya menampilkan satu tahun tabel.
   */
  private JButton thisYear = new JButton("This Year");
  /**
   * Atribut String untuk tanggal.
   */
  private String date = "";
  /**
   * Atribut Model Tabel.
   */
  private DefaultTableModel tabModel;
  /**
   * Atribut String tanggal.
   */
  private String tanggal;

  
  /**
   * Prosedur untuk membuat frame untuk menambahkan Income.
   */
  private void addIncomeFrame() {
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(400,300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setSize(400,300);
    panel.setBackground(Color.white);
    panel.setVisible(true);
    panel.setLayout(new GridLayout(0,1));

    JLabel dateLabel = new JLabel("Date : ");
    panel.add(dateLabel);
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    datePicker.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            date = datePicker.getJFormattedTextField().getText();
          }
        }
    );
    panel.add(datePicker);

    JLabel amountLabel = new JLabel("Amount : ");
    panel.add(amountLabel);

    panel.add(amountTextField);

    JLabel categoryLabel = new JLabel("Category : ");
    panel.add(categoryLabel);

    String[] ctgryOpt = {
            "Salary",
            "Bonus",
            "Reward",
            "Allowance"
    };

    JComboBox categoryList = new JComboBox(ctgryOpt);
    categoryList.setEditable(false);
    categoryList.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                selection = (String)cb.getSelectedItem();
              }
            }
    );
    panel.add(categoryList);
    selection = "Salary";

    JLabel descriptionLabel = new JLabel("Description : ");
    panel.add(descriptionLabel);

    panel.add(descriptionTextField);

    addIncButton.setBackground(Color.white);
    addIncButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(addIncButton);
    frame.add(panel);
  }

  /**
   * Prosedur untuk membuat frame untuk menambahkan Expense.
   */
  private void addExpenseFrame() {
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(400,300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setSize(400,300);
    panel.setBackground(Color.white);
    panel.setVisible(true);
    panel.setLayout(new GridLayout(0,1));

    JLabel dateLabel = new JLabel("Date : ");
    panel.add(dateLabel);
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    panel.add(datePicker);
    datePicker.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            date = datePicker.getJFormattedTextField().getText();
          }
        }
    );

    JLabel amountLabel = new JLabel("Amount : ");
    panel.add(amountLabel);

    panel.add(amountTextField);

    JLabel categoryLabel = new JLabel("Category : ");
    panel.add(categoryLabel);

    String[] ctgryOpt = {
            "Food",
            "Entertainment",
            "Utility",
            "Personal Care",
            "Transportation",
            "Tax"
    };

    JComboBox categoryList = new JComboBox(ctgryOpt);
    categoryList.setEditable(false);
    categoryList.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                selection = (String)cb.getSelectedItem();
              }
            }
    );
    panel.add(categoryList);
    selection = "Food";

    JLabel descriptionLabel = new JLabel("Description : ");
    panel.add(descriptionLabel);

    panel.add(descriptionTextField);

    addExpButton.setBackground(Color.white);
    addExpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(addExpButton);
    frame.add(panel);
  }

  /**
   * Constructor FinancialRecordView.
   * @param frmodel parameter FinancialRecordModel
   */
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

    JButton addIncomeButton = new JButton(" Add Income ");
    addIncomeButton.setBackground(Color.white);
    addIncomeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addIncomeButton);

    addIncomeButton.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                addIncomeFrame();
              }
            }
    );

    JButton addExpenseButton = new JButton("Add Expense");
    addExpenseButton.setBackground(Color.white);
    addExpenseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    controls.add(addExpenseButton);

    addExpenseButton.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                addExpenseFrame();
              }
            }
    );

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
    sortTable();
    JScrollPane tableContainer = new JScrollPane(table);

    JPanel controlBar = new JPanel();
    controlBar.setSize(550, 100);
    controlBar.setBackground(Color.gray);
    controlBar.setVisible(true);
    controlBar.setLayout(new GridLayout(1,0));

    today.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(today);
    today.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String month = Integer.toString(localDate.getMonthValue());
        String year = Integer.toString(localDate.getYear());
        String day = Integer.toString(localDate.getDayOfMonth());
        tanggal = year + "/" + month + "/" + day;
      }
    });

    thisMonth.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(thisMonth);
    thisMonth.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String month = Integer.toString(localDate.getMonthValue());
        String year = Integer.toString(localDate.getYear());
        tanggal = year + "/" + month + "/.*";
      }
    });

    thisYear.setAlignmentX(Component.CENTER_ALIGNMENT);
    controlBar.add(thisYear);
    thisYear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String year = Integer.toString(localDate.getYear());
        tanggal = year + "/.*";
      }
    });

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

  /**
   * Setter table record.
   * @param frmodel adalah FinancialRecordModel
   */
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

  /**
   * Prosedur untuk mengosongkan semua TextField.
   */
  public void resetField(){
    date = "";
    descriptionTextField.setText("");
    amountTextField.setText("");
    selection = "";
  }

  /**
   * Getter amountTextField.
   * @return amountTextField
   */
  public String getAmountTextField() {
    return amountTextField.getText();
  }

  /**
   * Getter descriptionTextField.
   * @return descriptionTextField
   */
  public String getDescriptionTextField() {
    return descriptionTextField.getText();
  }

  /**
   * Getter selection.
   * @return selection
   */
  public String getSelection() {
    return selection;
  }

  /**
   * Getter date.
   * @return date
   */
  public String getDate() {
    return date;
  }

  /**
   * Getter finaltable.
   * @return finaltable
   */
  public JTable getFinaltable(){
    return finaltable;
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenForAddIncomeButton parameter untuk cek apakah terdapat Event
   */
  public void addIncButtonListener(ActionListener listenForAddIncomeButton) {
    addIncButton.addActionListener(listenForAddIncomeButton);
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenForAddExpenseButton parameter untuk cek apakah terdapat Event
   */
  public void addExpButtonListener(ActionListener listenForAddExpenseButton) {
    addExpButton.addActionListener(listenForAddExpenseButton);
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenForAddUpdateButton parameter untuk cek apakah terdapat Event
   */
  public void addUpdateButtonListener(ActionListener listenForAddUpdateButton) {
    addUpdateButton.addActionListener(listenForAddUpdateButton);
  }

  /**
   * Menambahkan listener untuk komponen.
   * @param listenForAddDeleteButton parameter untuk cek apakah terdapat Event
   */
  public void addDeleteButtonListener(ActionListener listenForAddDeleteButton) {
    addDeleteButton.addActionListener(listenForAddDeleteButton);
  }
  
  public void sortTable() {
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(finaltable.getModel());
    finaltable.setRowSorter(sorter);
    
    ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<>();
    sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys); 
    filterTable(sorter);
  }
  
  public void filterTable(TableRowSorter<TableModel> sorter) {
    RowFilter<TableModel, Object> rf = null;
    //If current expression doesn't parse, don't update.
    try {
        rf = RowFilter.regexFilter(tanggal,1);
    } catch (java.util.regex.PatternSyntaxException e) {
        return;
    }
    sorter.setRowFilter(rf);   
  }
}