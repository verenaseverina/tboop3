
import java.util.ArrayList;

/**
 *
 * Kelas model untuk financial records.
 * Kelas FRModel memiliki atribut array list data pemasukkan,
 * array list data pengeluaran, informasi saldo, dan informasi tabungan
 * 
 * @author Verena Severina 
 * @author Adrian Hartarto
 */
public class FinancialRecordModel {
  /**
   * Atribut array list of Record dari FRModel (data pemasukkan).
   */
  private ArrayList<Record> income;
  /**
   * Atribut array list of Record dari FRModel (data pengeluaran).
   */
  private ArrayList<Record> outcome;
  /**
   * Atribut long dari FRModel (data saldo).
   */
  private long balance;
  /**
   * Atribut long dari FRModel (data tabungan).
   */
  private long savings;
  
  /**
   * Menginisialisasi atribut dari FRModel.
   */
  public FinancialRecordModel() {
    income = new ArrayList<>();
    outcome = new ArrayList<>();
    balance = 0;
    savings = 0;
  }
  
  /**
   * Getter income.
   * @return income
   */
  public ArrayList<Record> getIncome() {
    return income;
  }
  
  /**
   * Getter outcome.
   * @return outcome
   */
  public ArrayList<Record> getOutcome() {
    return outcome;
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
  public void setIncome(String type, int idx, Record rec) {
    if (type.compareTo("add") == 0) {
      income.add(rec);
    } 
    else if(type.compareTo("delete") == 0) {
      income.remove(idx);
    }
  }
  
   /**
   * Setter outcome
   * @param type pemilihan cara penambahan/penghapusan
   * @param idx index dari array list
   * @param rec reocord yang ingin ditambahkan
   */
  public void setOutcome(String type, int idx, Record rec) {
    if (type.compareTo("add") == 0) {
      outcome.add(rec);
    } 
    else if(type.compareTo("delete") == 0) {
      outcome.remove(idx);
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
}
