package financialrecords;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinancialRecordViewTest {
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Parse Test");
    System.out.println("--------------------");
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("The Test is Complete");
    System.out.println("--------------------");
    System.out.println();
    System.out.println();
  }

  /**
   * Test of getDescriptionTextField method, of class FinancialRecordView.
   */
  @Test
  public void getDescriptionTextField() throws Exception {
    System.out.print("Test getDescriptionTextField... ");
    FinancialRecordView frView = new FinancialRecordView(new FinancialRecordModel());
    Assert.assertTrue(frView.getDescriptionTextField() != null);
    System.out.println("OK");
  }


}