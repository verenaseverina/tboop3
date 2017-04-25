package setting;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingViewTest {
  @BeforeClass
  public static void setUpClass() {
    System.out.println("SettingView Test");
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
   * Test of getOKButton method, of class SettingView.
   */
  @Test
  public void getOKButton() throws Exception {
    System.out.print("Test getOKButton... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getOKButton()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getCancelButton method, of class SettingView.
   */
  @Test
  public void getCancelButton() throws Exception {
    System.out.print("Test getCancelButton... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getCancelButton()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getResetButton method, of class SettingView.
   */
  @Test
  public void getResetButton() throws Exception {
    System.out.print("Test getResetButton... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getResetButton()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getCheckBoxLock method, of class SettingView.
   */
  @Test
  public void getCheckBoxLock() throws Exception {
    System.out.print("Test getCheckBoxLock... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getCheckBoxLock()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getPasswordField method, of class SettingView.
   */
  @Test
  public void getPasswordField() throws Exception {
    System.out.print("Test getPasswordField... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getPasswordField()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getHint method, of class SettingView.
   */
  @Test
  public void getHint() throws Exception {
    System.out.print("Test getHint... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getHint()!=null);
    System.out.println("OK");
  }

  /**
   * Test of getSuccessLabel method, of class SettingView.
   */
  @Test
  public void getSuccessLabel() throws Exception {
    System.out.print("Test getSuccessLabel... ");
    SettingView setV = new SettingView();
    Assert.assertTrue(setV.getSuccessLabel()!=null);
    System.out.println("OK");
  }

}