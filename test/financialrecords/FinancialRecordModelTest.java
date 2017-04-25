package financialrecords;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Winarto on 04/25/2017.
 */
public class FinancialRecordModelTest {
  /**
   * Test of getIncome method, of class FinancialRecordModel.
   */
  @Test
  public void getIncome() throws Exception {
    System.out.print("Test getIncome... ");
    FinancialRecordModel frModel = new FinancialRecordModel();
    Assert.assertTrue(frModel.getIncome() != null);
    System.out.println("OK");
  }

  /**
   * Test of getExpense method, of class FinancialRecordModel.
   */
  @Test
  public void getExpense() throws Exception {
    System.out.print("Test getExpense... ");
    FinancialRecordModel frModel = new FinancialRecordModel();
    Assert.assertTrue(frModel.getExpense() != null);
    System.out.println("OK");
  }

  /**
   * Test of getBalance method, of class FinancialRecordModel.
   */
  @Test
  public void getBalance() throws Exception {
    System.out.print("Test getBalance... ");
    FinancialRecordModel frModel = new FinancialRecordModel();
    Assert.assertTrue(frModel.getBalance() == 0);
    System.out.println("OK");
  }

  /**
   * Test of getSavings method, of class FinancialRecordModel.
   */
  @Test
  public void getSavings() throws Exception {
    System.out.print("Test getSavings... ");
    FinancialRecordModel frModel = new FinancialRecordModel();
    Assert.assertTrue(frModel.getSavings() == 0);
    System.out.println("OK");
  }

  /**
   * Test of size method, of class FinancialRecordModel.
   */
/*
  @Test
  public void size() throws Exception {
    System.out.print("Test size... ");
    FinancialRecordModel frModel = new FinancialRecordModel();
    Assert.assertTrue(frModel.size() >= 0);
    System.out.println("OK");
  }
*/

}