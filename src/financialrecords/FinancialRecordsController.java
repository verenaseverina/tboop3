package financialrecords;

import financialrecords.records.Record;
import parse.Parse;

/**
 * Kelas controller untuk financial records.
 * Kelas FinancialRecordsController memiliki atribut
 * FinancialRecordsModel.
 *
 * @author Kukuh Basuki Rahmat
 * @author Verena Severina
 */
public class FinancialRecordsController {
  /**
   * Atribut financialrecords.FinancialRecordModel.
   */
  private FinancialRecordModel frmodel;

  /**
   * Ctor dari FinancialRecordsController.
   * @param parser adalah kelas untuk melakukan parsing
   */
  public FinancialRecordsController(Parse parser) {
    for (int idx = 0; idx < parser.getIn().size(); idx++) {
      frmodel.setIncome("add", idx, parser.getIn().get(idx));
    }
    
    for (int idx = 0; idx < parser.getOut().size(); idx++) {
      frmodel.setOutcome("add", idx, parser.getOut().get(idx));
    }
    
    long sumIn = 0;
    for (int idx = 0; idx < frmodel.getIncome().size(); idx++) {
      sumIn += frmodel.getIncome().get(idx).getAmount();
    }

    long sumOut = 0;
    for (int idx = 0; idx < frmodel.getOutcome().size(); idx++) {
      sumOut += frmodel.getOutcome().get(idx).getAmount();
    }
    frmodel.setBalance(sumIn-sumOut);
  }

  /**
   * Menambahkan Record pada ArrayList income.
   * @param rec adalah Record yang akan ditambahkan
   */
  public void addIncome(Record rec) {
    int idx = findDateIncome(rec.getDate());
    frmodel.setIncome("add", idx, rec);
  }

  /**
   * Mencari index penempatan record.
   * @param date adalah tanggal yang akan dicari index penempatannya
   * @return index tempat ditemukannya posisi penempatan tanggal
   */
  public int findDateIncome(String date) { // ntar ini diubah kalo datenya udah ga string
    int idx = 0;
    boolean found = false;

    while ((idx < frmodel.getIncome().size()) && !found) {
      if (frmodel.getIncome().get(idx).getDate().equals(date)) {
        found = true;
      } else {
        idx++;
      }
    }

    return idx;
  }

  /**
   * Menambahkan Record pada ArrayList outcome.
   * @param rec adalah Record yang akan ditambahkan
   */
  public void addOutcome(Record rec) {
    int idx = findDateOutcome(rec.getDate());
    frmodel.setOutcome("add", idx, rec);
  }

  /**
   * Mencari index penempatan record.
   * @param date adalah tanggal yang akan dicari index penempatannya
   * @return index tempat ditemukannya posisi penempatan tanggal
   */
  private int findDateOutcome(String date) { // ntar ini diubah kalo datenya udah ga string
    int idx = 0;
    boolean found = false;

    while ((idx < frmodel.getOutcome().size()) && !found) {
      if (frmodel.getOutcome().get(idx).getDate().equals(date)) {
        found = true;
      } else {
        idx++;
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

    for (int idx = 0; idx < frmodel.getOutcome().size(); idx++) {
      sum += frmodel.getOutcome().get(idx).getAmount();
    }

    return sum;
  }

  /**
   * Menghitung rekomendasi pengeluaran.
   * @return rekomendasi pengeluaran
   */
  public long countRecommendedOutcome() {
    return 0;
  }

  /**
   * Menghapus Record pada ArrayList income.
   * @param idx adalah index dari Record yang akan dihapus
   */
  public void deleteIncome(int idx) {
    Record temprec = new Record("","0","","");
    frmodel.setIncome("delete", idx, temprec);
  }

  /**
   * Menghapus Record pada ArrayList outcome.
   * @param idx adalah index dari Record yang akan dihapus
   */
  public void deleteOutcome(int idx) {
    Record temprec = new Record("","0","","");
    frmodel.setOutcome("delete", idx, temprec);
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
  public void updateOutcome(int idx, String amount, String category, String description) {
    frmodel.getOutcome().get(idx).setAmount(amount);
    frmodel.getOutcome().get(idx).setCategory(category);
    frmodel.getOutcome().get(idx).setDescription(description);
  }
}
