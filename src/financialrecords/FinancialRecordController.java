package financialrecords;

import financialrecords.records.NewDate;
import financialrecords.records.Record;
import financialrecords.records.recordderivative.Expense;
import financialrecords.records.recordderivative.Income;
import mediator.Mediator;
import parse.Parse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Kelas controller untuk financial records.
 * Kelas FinancialRecordController memiliki atribut
 * FinancialRecordsModel.
 *
 * @author Kukuh Basuki Rahmat
 * @author Verena Severina
 */
public class FinancialRecordController {
  /**
   * Atribut financialrecords.FinancialRecordModel.
   */
  private FinancialRecordModel frmodel;
  /**
   * Atribut financialrecords.FinancialRecordView.
   */
  private FinancialRecordView frview;
  /**
   * Atribut Mediator.
   */
  private Mediator med;

  public FinancialRecordController(Mediator _med, Parse parser) {
    med = _med;
    this.frmodel = new FinancialRecordModel(parser);
    this.frview = new FinancialRecordView(frmodel);

    this.frview.addIncButtonListener(new addIncomeListener());
    this.frview.addExpButtonListener(new addExpenseListener());
    this.frview.addUpdateButtonListener(new addUpdateListener());
    this.frview.addDeleteButtonListener(new addDeleteListener());
    this.frview.addThisWeekListener(new thisWeekListener());
    this.frview.addThisMonthListener(new thisMonthListener());
    this.frview.addThisYearListener(new thisYearListener());
  }

    class addIncomeListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton addIncomeBtn = (JButton)e.getSource();
      JFrame incomeFrame = (JFrame)addIncomeBtn.getRootPane().getParent();
      if(frview.getDate().equals(""))
        return;
      Income tmp = new Income(frview.getDate(),frview.getAmountTextField(),frview.getDescriptionTextField(),frview.getSelection());
      addIncome(tmp);
      frmodel.saveData();
      DefaultTableModel model = (DefaultTableModel) frview.getFinaltable().getModel();
      model.addRow(new Object[]{"Income",frview.getDate(), tmp.getAmount(), tmp.getDescription(),tmp.getCategory()});
      incomeFrame.dispose();
      frview.resetField();
    }
  }

  class addExpenseListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      JButton addIncomeBtn = (JButton)e.getSource();
      JFrame incomeFrame = (JFrame)addIncomeBtn.getRootPane().getParent();
      if(frview.getDate().equals(""))
        return;
      Expense tmp = new Expense(frview.getDate(),frview.getAmountTextField(),frview.getDescriptionTextField(),frview.getSelection());
      addOutcome(tmp);
      frmodel.saveData();
      DefaultTableModel model = (DefaultTableModel) frview.getFinaltable().getModel();
      model.addRow(new Object[]{"Expense",frview.getDate(), tmp.getAmount(), tmp.getDescription(),tmp.getCategory()});
      incomeFrame.dispose();
      frview.resetField();
    }
  }

  class addUpdateListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

    }
  }

  class addDeleteListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      int numRows = frview.getFinaltable().getSelectedRows().length;
      DefaultTableModel model = (DefaultTableModel) frview.getFinaltable().getModel();
      for(int i=0; i<numRows ; i++ ) {
          boolean isIncome =(model.getValueAt(frview.getFinaltable().getSelectedRow(),0) == "Income");
          boolean found = false;
          int inIdx = 0;
          String[] tmp = new String[4];
          for (int idx = 0; idx < 4;idx++) {
            tmp[idx] = String.valueOf(model.getValueAt(frview.getFinaltable().getSelectedRow(), idx + 1));
            System.out.println(tmp[idx]);
          }
          while(inIdx<frmodel.getIncome().size() && !found){
            boolean dateEqual,amountEqual,descEqual,catEqual;
            if(isIncome) {
              dateEqual = (tmp[0].equals(frmodel.getIncome().get(inIdx).getDate().toString()));
              amountEqual = (tmp[1].equals(Long.toString(frmodel.getIncome().get(inIdx).getAmount())));
              descEqual = (tmp[2].equals(frmodel.getIncome().get(inIdx).getDescription()));
              catEqual = (tmp[3].equals(frmodel.getIncome().get(inIdx).getCategory()));
            } else {
              dateEqual = (tmp[0].equals(frmodel.getExpense().get(inIdx).getDate().toString()));
              amountEqual = (tmp[1].equals(Long.toString(frmodel.getExpense().get(inIdx).getAmount())));
              descEqual = (tmp[2].equals(frmodel.getExpense().get(inIdx).getDescription()));
              catEqual = (tmp[3].equals(frmodel.getExpense().get(inIdx).getCategory()));
            }
            found = (dateEqual && amountEqual && descEqual && catEqual);
          }
          if(found) {
            if(isIncome) {
              deleteIncome(inIdx);
              saveData();
            } else {
              deleteExpense(inIdx);
              saveData();
            }
          }
        model.removeRow(frview.getFinaltable().getSelectedRow());
      }
    }
  }

  class thisWeekListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

    }
  }

  class thisMonthListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

    }
  }

  class thisYearListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

    }
  }

  /**
   * Menampilkan atau menyembunyikan tampilan financial record
   */
  public void visible(boolean state) {
    frview.setVisible(state);
  }

  /**
   * Menambahkan Record pada ArrayList income.
   * @param rec adalah Record yang akan ditambahkan
   */
  public void addIncome(Income rec) {
    int idx = findDateIncome(rec.getDate());
    frmodel.setIncome("add", idx, rec);
  }

  /**
   * Mencari index penempatan record.
   * @param date adalah tanggal yang akan dicari index penempatannya
   * @return index tempat ditemukannya posisi penempatan tanggal
   */
  public int findDateIncome(NewDate date) {
    int idx = 0;
    boolean found = false;
    int dateYear = Integer.parseInt(date.getYear());
    int dateMonth = Integer.parseInt(date.getMonth());
    int dateDay = Integer.parseInt(date.getDay());

    while ((idx < frmodel.getIncome().size()) && !found) {
      int year = Integer.parseInt(frmodel.getIncome().get(idx).getDate().getYear());
      int month = Integer.parseInt(frmodel.getIncome().get(idx).getDate().getMonth());
      int day = Integer.parseInt(frmodel.getIncome().get(idx).getDate().getDay());
      if (year > dateYear) {
        found = true;
      } else {
        if (month > dateMonth) {
          found = true;
        } else {
          if (day > dateDay) {
            found = true;
          } else {
            idx++;
          }
        }
      }
    }

    return idx;
  }

  /**
   * Menambahkan Record pada ArrayList outcome.
   * @param rec adalah Record yang akan ditambahkan
   */
  public void addOutcome(Expense rec) {
    int idx = findDateExpense(rec.getDate());
    frmodel.setExpense("add", idx, rec);
  }

  /**
   * Mencari index penempatan record.
   * @param date adalah tanggal yang akan dicari index penempatannya
   * @return index tempat ditemukannya posisi penempatan tanggal
   */
  private int findDateExpense(NewDate date) {
    int idx = 0;
    boolean found = false;
    int dateYear = Integer.parseInt(date.getYear());
    int dateMonth = Integer.parseInt(date.getMonth());
    int dateDay = Integer.parseInt(date.getDay());

    while ((idx < frmodel.getIncome().size()) && !found) {
      int year = Integer.parseInt(frmodel.getExpense().get(idx).getDate().getYear());
      int month = Integer.parseInt(frmodel.getExpense().get(idx).getDate().getMonth());
      int day = Integer.parseInt(frmodel.getExpense().get(idx).getDate().getDay());
      if (year > dateYear) {
        found = true;
      } else {
        if (month > dateMonth) {
          found = true;
        } else {
          if (day > dateDay) {
            found = true;
          } else {
            idx++;
          }
        }
      }
    }

    return idx;
  }

  /**
   * Menghitung dan menyimpan nilai Balance.
   */
  public void countBalance() {
    frmodel.setBalance(sumIncome() - sumOutcome());
  }

  /**
   * Menjumlahkan semua amount pada ArrayList income.
   * @return jumlah dari semua amount pada ArrayList income
   */
  public long sumIncome() {
    long sum = 0;

    for (int idx = 0; idx < frmodel.getIncome().size(); idx++) {
      sum += frmodel.getIncome().get(idx).getAmount();
    }

    return sum;
  }

  /**
   * Menjumlahkan semua amount pada ArrayList outcome.
   * @return jumlah dari semua amount pada ArrayList outcome
   */
  public long sumOutcome() {
    long sum = 0;

    for (int idx = 0; idx < frmodel.getExpense().size(); idx++) {
      sum += frmodel.getExpense().get(idx).getAmount();
    }

    return sum;
  }

  /**
   * Menghitung rekomendasi pengeluaran.
   * @return rekomendasi pengeluaran
   */
  public double countRecommendedExpense() {
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int month = localDate.getMonthValue();
    int year = localDate.getYear();
    Calendar cal = new GregorianCalendar(year,month-1,1);
    int numberOfDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    double incomeInMonth = 0;

    for (int idx = 0; idx<frmodel.getIncome().size();idx++){
      int inMonth = Integer.parseInt(frmodel.getIncome().get(idx).getDate().getMonth());
      int inYear = Integer.parseInt(frmodel.getIncome().get(idx).getDate().getYear());
      if(inMonth == month && inYear == year){
        incomeInMonth += (double) frmodel.getIncome().get(idx).getAmount();
      }
    }
    incomeInMonth = (incomeInMonth-frmodel.getSavings())/numberOfDay;
    return (incomeInMonth >= 0 ? incomeInMonth : 0);
  }

  /**
   * Menghapus Record pada ArrayList income.
   * @param idx adalah index dari Record yang akan dihapus
   */
  public void deleteIncome(int idx) {
    Income tempinc = new Income("00/00/0000","0","","");
    frmodel.setIncome("delete", idx, tempinc);
  }

  /**
   * Menghapus Record pada ArrayList outcome.
   * @param idx adalah index dari Record yang akan dihapus
   */
  public void deleteExpense(int idx) {
    Expense tempexp = new Expense("00/00/0000","0","","");
    frmodel.setExpense("delete", idx, tempexp);
  }

  /**
   * Melakukan update untuk ArrayList income.
   * @param idx adalah index dari Record yang akan di-update
   * @param amount adalah amount dari Record yang akan di-update
   * @param category adalah category dari Record yang akan di-update
   * @param description adalah description dari Record yang akan di-update
   */
  public void updateIncome(int idx, String amount, String category, String description) {
    frmodel.getIncome().get(idx).setAmount(amount);
    frmodel.getIncome().get(idx).setCategory(category);
    frmodel.getIncome().get(idx).setDescription(description);
  }

  /**
   * Melakukan update untuk ArrayList outcome.
   * @param idx adalah index dari Record yang akan di-update
   * @param amount adalah amount dari Record yang akan di-update
   * @param category adalah category dari Record yang akan di-update
   * @param description adalah description dari Record yang akan di-update
   */
  public void updateExpense(int idx, String amount, String category, String description) {
    frmodel.getExpense().get(idx).setAmount(amount);
    frmodel.getExpense().get(idx).setCategory(category);
    frmodel.getExpense().get(idx).setDescription(description);
  }

  /**
   * Mengupdate jumlah tabungan
   * @param amount jumlah yang ingin ditabung
   */
  public void updateSavings(int amount){
    frmodel.setSavings(amount);
  }

  /**
   * Mengambil jumlah yang ingin tabungan
   */
  public long getSavings(){
    return frmodel.getSavings();
  }

  /**
   * Mengambil arraylist income
   */
  public ArrayList<Income> getIncome() {
    return frmodel.getIncome();
  }

  /**
   * Mengambil arraylist outcome
   */
  public ArrayList<Expense> getOutcome() {
    return frmodel.getExpense();
  }

  /**
   * Menyimpan data pengeluaran dan pemasukan
   */
  public void saveData(){
    frmodel.saveData();
  }
}
