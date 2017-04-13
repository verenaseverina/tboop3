package financialrecords;

import java.util.ArrayList;
import java.util.Date;

public class FinancialRecordsController {
  private FinancialRecordsModel frmodel;

  public FinancialRecordsController() {

  }

  public void addIncome(Records rec) {

  }

  public void addOutcome(Records rec) {

  }

  public void countBalance() {
    frmodel.setBalance(sumIncome() - sumOutcome());
  }

  public int sumIncome() {
    int sum = 0;

    for (int i = 0; i < frmodel.getIncome().size(); i++) {
      sum += frmodel.getIncome().get(i).amount;
    }

    return sum;
  }

  public int sumOutcome() {
    int sum = 0;

    for (int i = 0; i < frmodel.getOutcome().size(); i++) {
      sum += frmodel.getOutcome().get(i).amount;
    }

    return sum;
  }

  public int countRecommendedOutcome() {

  }

  public void deleteIncome(Date date) {

  }

  public void deleteOutcome(Date date) {

  }

  public void updateOutcome(Date date, int amount, String category, String description) {

  }

  public void updateIncome(Date date, int amount, String category, String description) {

  }
}
