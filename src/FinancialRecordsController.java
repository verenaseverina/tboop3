
public class FinancialRecordsController {
  private FinancialRecordModel frmodel;

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
    
  }

  public void addOutcome(Record rec) {
    
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

  public void deleteIncome(int i) {

  }

  public void deleteOutcome(int i) {

  }

  public void updateOutcome(int i, int amount, String category, String description) {

  }

  public void updateIncome(int i, int amount, String category, String description) {

  }
}
