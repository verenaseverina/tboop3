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
  private FinancialRecordModel frmodel;

  private int findDateIncome(Record rec) { // ntar ini diubah kalo datenya udah ga string
    int idx = 0;
    boolean found = false;
    String compare = rec.getDate();

    while ((idx < frmodel.getIncome().size()) && !found) {
      if (frmodel.getIncome().get(idx).getDate().equals(compare)) {
        found = true;
      } else {
        idx++;
      }
    }

    return idx;
  }

  private int findDateOutcome(Record rec) { // ntar ini diubah kalo datenya udah ga string
    int idx = 0;
    boolean found = false;
    String compare = rec.getDate();

    while ((idx < frmodel.getOutcome().size()) && !found) {
      if (frmodel.getOutcome().get(idx).getDate().equals(compare)) {
        found = true;
      } else {
        idx++;
      }
    }

    return idx;
  }

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

  public void addIncome(Record rec) {
    int idx = findDateIncome(rec);
    frmodel.setIncome("add", idx, rec);
  }

  public void addOutcome(Record rec) {
    int idx = findDateOutcome(rec);
    frmodel.setOutcome("add", idx, rec);
  }

  public void countBalance() {
    frmodel.setBalance(sumIncome() - sumOutcome());
  }

  public long sumIncome() {
    long sum = 0;

    for (int idx = 0; idx < frmodel.getIncome().size(); idx++) {
      sum += frmodel.getIncome().get(idx).getAmount();
    }

    return sum;
  }

  public long sumOutcome() {
    long sum = 0;

    for (int idx = 0; idx < frmodel.getOutcome().size(); idx++) {
      sum += frmodel.getOutcome().get(idx).getAmount();
    }

    return sum;
  }

  public long countRecommendedOutcome() {
    return 0;
  }

  public void deleteIncome(int idx) {
    Record temprec = new Record("","0","","");
    frmodel.setIncome("add", idx, temprec);
  }

  public void deleteOutcome(int idx) {
    Record temprec = new Record("","0","","");
    frmodel.setOutcome("add", idx, temprec);
  }

  public void updateIncome(int idx, String amount, String category, String description) {
    String date = frmodel.getIncome().get(idx).getDate();
    Record rec = new Record(date, amount, description, category);
    frmodel.getIncome().set(idx,rec);
  }

  public void updateOutcome(int idx, String amount, String category, String description) {
    String date = frmodel.getOutcome().get(idx).getDate();
    Record rec = new Record(date, amount, description, category);
    frmodel.getOutcome().set(idx,rec);
  }
}
