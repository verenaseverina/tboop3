package financialrecords;

import parse.Parse;

/**
 * Created by verenaseverina on 4/23/17.
 */
public class MvcFinancialRecord {
  private FinancialRecordModel frmodel;
  private Parse parser;
  public MvcFinancialRecord() {
    parser = new Parse();
    frmodel = new FinancialRecordModel(parser);
    FinancialRecordView frView = new FinancialRecordView(frmodel);
  }
  
  
  //FinancialRecordController frController = new FinancialRecordController(frModel,frView);
}
