package financialrecords;

/**
 * Created by verenaseverina on 4/23/17.
 */
public class MvcFinancialRecord {
  FinancialRecordModel frModel = new FinancialRecordModel();
  FinancialRecordView frView = new FinancialRecordView();

  FinancialRecordController frController = new FinancialRecordController(frModel,frView);
}
