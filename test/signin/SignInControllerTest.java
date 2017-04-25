package signin;

import mediator.Mediator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import parse.Parse;

import static org.junit.Assert.*;

public class SignInControllerTest {
  @BeforeClass
  public static void setUpClass() {
    System.out.println("SignInController Test");
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
   * Test of validatePassword method, of class SignInModel.
   */
  @Test
  public void validatePassword() throws Exception {
    System.out.print("Test validatePassword... ");
    SignInController controller = new SignInController();
    Assert.assertTrue(controller.validatePassword(controller.getSignInPass()));
    System.out.println("OK");
  }

  /**
   * Test of getSignInID method, of class SignInModel.
   */
  @Test
  public void getSignInID() throws Exception {
    System.out.print("Test getSignInID... ");
    SignInController controller = new SignInController();
    Assert.assertTrue(controller.getSignInID().equals("0"));
    System.out.println("OK");
  }

  /**
   * Test of getSignInPass method, of class SignInModel.
   */
  @Test
  public void getSignInPass() throws Exception {
    System.out.print("Test getSignInPass... ");
    SignInController controller = new SignInController();
    Assert.assertTrue(controller.getSignInPass().equals(""));
    System.out.println("OK");
  }

  /**
   * Test of getSignInDesc method, of class SignInModel.
   */
  @Test
  public void getSignInDesc() throws Exception {
    System.out.print("Test getSignInDesc... ");
    SignInController controller = new SignInController();
    Assert.assertTrue(controller.getSignInDesc().equals(""));
    System.out.println("OK");
  }

}