package financialrecords;

import java.util.ArrayList;
import financialrecords.records.Record;
import financialrecords.records.recordderivative.Expense;
import financialrecords.records.recordderivative.Income;
import parse.Parse;

import javax.xml.transform.TransformerException;

/**
 *
 * Kelas model untuk financial records.
 * Kelas FinancialRecordsModel memiliki atribut array list data pemasukkan,
 * array list data pengeluaran, informasi saldo, dan informasi tabungan
 * 
 * @author Verena Severina 
 * @author Adrian Hartarto
 */
public class FinancialRecordModel {
  /**
   * Atribut array list of financialrecords.records.Record dari FRModel (data pemasukkan).
   */
  private ArrayList<Income> income;
  /**
   * Atribut array list of financialrecords.records.Record dari FRModel (data pengeluaran).
   */
  private ArrayList<Expense> expense;
  /**
   * Atribut long dari FRModel (data saldo).
   */
  private long balance;
  /**
   * Atribut long dari FRModel (data tabungan).
   */
  private long savings;
  /**
   * Atribut parser untuk mengupdate data.
   */
  private Parse parser;
  /**
   * Menginisialisasi atribut dari FRModel.
   */
  public FinancialRecordModel() {
    income = new ArrayList<>();
    expense = new ArrayList<>();
    balance = 0;
    savings = 0;
  }

  /**
   * Ctor dari FinancialRecordModel.
   * @param parser adalah kelas untuk melakukan parsing
   */
  public FinancialRecordModel(Parse parser) {
    this.parser = parser;
    income = new ArrayList<>();
    expense = new ArrayList<>();
    for (int idx = 0; idx < parser.getIn().size(); idx++) {
      income.add(idx,parser.getIn().get(idx));
    }

    for (int idx = 0; idx < parser.getOut().size(); idx++) {
      expense.add(idx,parser.getOut().get(idx));
    }

    long sumIn = 0;
    for (int idx = 0; idx < income.size(); idx++) {
      sumIn += income.get(idx).getAmount();
    }

    long sumOut = 0;
    for (int idx = 0; idx < expense.size(); idx++) {
      sumOut += expense.get(idx).getAmount();
    }
    savings = parser.getTabungan();
    balance = sumIn - sumOut;
  }
  
  /**
   * Getter income.
   * @return income
   */
  public ArrayList<Income> getIncome() {
    return income;
  }
  
  /**
   * Getter expense.
   * @return expense
   */
  public ArrayList<Expense> getExpense() {
    return expense;
  }
  
  /**
   * Geter balance.
   * @return balance
   */
  public long getBalance() {
    return balance;
  }
  
  /**
   * Getter savings.
   * @return savings
   */
  public long getSavings() {
    return savings;
  }
  
   /**
   * Setter income
   * @param type pemilihan cara penambahan/penghapusan
   * @param idx index dari array list
   * @param rec reocord yang ingin ditambahkan
   */
  public void setIncome(String type, int idx, Income rec) {
    if (type.compareTo("add") == 0) {
      income.add(idx, rec);
    } 
    else if(type.compareTo("delete") == 0) {
      income.remove(idx);
    }
  }
  
   /**
   * Setter expense
   * @param type pemilihan cara penambahan/penghapusan
   * @param idx index dari array list
   * @param rec reocord yang ingin ditambahkan
   */
  public void setExpense(String type, int idx, Expense rec) {
    if (type.compareTo("add") == 0) {
      expense.add(idx, rec);
    } 
    else if(type.compareTo("delete") == 0) {
      expense.remove(idx);
    }
  }
  
  /**
   * Setter balance.
   * @param bal long yang ingin disimpan
   */
  public void setBalance(long bal) {
    balance = bal;
  }
  
  /**
   * Setter savings.
   * @param tabungan long yang ingin disimpan
   */
  public void setSavings(long tabungan) {
    savings = tabungan;
  }

  /**
   * Menyimpan semua data pengeluaran dan pemasukan
   */
  public void saveData() {
    parser.setIn(income);
    parser.setOut(expense);
    parser.setTabungan(savings);
    try {
      parser.saveFile();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

  int size() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
