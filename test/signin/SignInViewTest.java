package signin;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignInViewTest {
  @BeforeClass
  public static void setUpClass() {
    System.out.println("SignInView Test");
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
   * Test of getInputPassword method, of class SignInView.
   */
  @Test
  public void getInputPassword() throws Exception {
    System.out.print("Test getInputPassword... ");
    SignInView signInV = new SignInView();
    Assert.assertTrue(signInV.getInputPassword()!=null);
    System.out.println("OK");
  }

}