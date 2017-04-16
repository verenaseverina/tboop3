package financialrecords;

import financialrecords.records.NewDate;
import financialrecords.records.Record;
import parse.Parse;

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
   * Ctor dari FinancialRecordController.
   * @param parser adalah kelas untuk melakukan parsing
   */
  public FinancialRecordController(Parse parser) {
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
  public void addOutcome(Record rec) {
    int idx = findDateOutcome(rec.getDate());
    frmodel.setOutcome("add", idx, rec);
  }

  /**
   * Mencari index penempatan record.
   * @param date adalah tanggal yang akan dicari index penempatannya
   * @return index tempat ditemukannya posisi penempatan tanggal
   */
  private int findDateOutcome(NewDate date) {
    int idx = 0;
    boolean found = false;
    int dateYear = Integer.parseInt(date.getYear());
    int dateMonth = Integer.parseInt(date.getMonth());
    int dateDay = Integer.parseInt(date.getDay());

    while ((idx < frmodel.getIncome().size()) && !found) {
      int year = Integer.parseInt(frmodel.getOutcome().get(idx).getDate().getYear());
      int month = Integer.parseInt(frmodel.getOutcome().get(idx).getDate().getMonth());
      int day = Integer.parseInt(frmodel.getOutcome().get(idx).getDate().getDay());
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