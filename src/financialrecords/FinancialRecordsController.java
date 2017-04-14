package financialrecords;

import java.util.ArrayList;
import java.util.Date;

public class FinancialRecordsController {
  private FinancialRecordsModel frmodel;

  public FinancialRecordsController() {

  }

  public void addIncome(Records rec) {
    int idx = 0;
    frmodel.setIncome(idx,rec); // kalo yang berdasarkan tanggal gimana?
  }

  public void addOutcome(Records rec) {
    int idx = 0;
    frmodel.setOutcome(idx,rec); // kalo yang berdasarkan tanggal gimana?
  }

  public void countBalance() {
    frmodel.setBalance(sumIncome() - sumOutcome());
  }

  public long sumIncome() {
    long sum = 0;

    for (int i = 0; i < frmodel.getIncome().size(); i++) {
      sum += frmodel.getIncome().get(i).amount;
    }

    return sum;
  }

  public long sumOutcome() {
    long sum = 0;

    for (int i = 0; i < frmodel.getOutcome().size(); i++) {
      sum += frmodel.getOutcome().get(i).amount;
    }

    return sum;
  }

  public long countRecommendedOutcome() {

  }

  public void deleteIncome(int i) {

  }

  public void deleteOutcome(int i) {

  }

  public void updateOutcome(int i, int amount, String category, String description) {

  }

  public void updateIncome(int i, int amount, String category, String description) {

  }
}
