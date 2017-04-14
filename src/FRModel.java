
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
public class FRModel {
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
  public FRModel() {
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
   * @param in array list yang ingin disimpan
   */
  public void setIncome(ArrayList<Record> in) {
    for (int idx = 0; idx < in.size(); idx++) {
      income.remove(idx);
    }
    
    for (int idx = 0; idx < in.size(); idx++) {
      income.add(in.get(idx));
    }
  }
  
   /**
   * Setter outcome
   * @param out array list yang ingin disimpan
   */
  public void setOutcome(ArrayList<Record> out) {
    for (int idx = 0; idx < outcome.size(); idx++) {
      outcome.remove(idx);
    }
    
    for (int idx = 0; idx < out.size(); idx++) {
      outcome.add(out.get(idx));
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
