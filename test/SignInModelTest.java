/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nim_13515091
 */
public class SignInModelTest {
  
  public SignInModelTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("SignInModel Test");
    System.out.println("--------------------");
  }
  
  @AfterClass
  public static void tearDownClass() {
    System.out.println("The Test is Complete");
    System.out.println("--------------------");
    System.out.println();
    System.out.println();
  }
  
  @Before
  public void setUp() {
    
  }
  
  @After
  public void tearDown() {
    System.out.println();
  }

  /**
   * Test of getId method, of class SignInModel.
   */
  @Test
  public void testGetId() {
    System.out.print("Test getID... ");
    SignInModel model = new SignInModel();
    String str = "0";
    String id = model.getId();
    assertEquals(str, id);
    System.out.println("OK");
  }

  /**
   * Test of getPass method, of class SignInModel.
   */
  @Test
  public void testGetPass() {
    System.out.print("Test getPass... ");
    SignInModel model = new SignInModel();
    String str = "";
    String pass = model.getPass();
    assertEquals(str, pass);
    System.out.println("OK");
  }

  /**
   * Test of getDescription method, of class SignInModel.
   */
  @Test
  public void testGetDescription() {
    System.out.print("Test getDescription... ");
    SignInModel instance = new SignInModel();
    String str = "";
    String desc = instance.getDescription();
    assertEquals(str, desc);
    System.out.println("OK");
  }

  /**
   * Test of setId method, of class SignInModel.
   */
  @Test
  public void testSetId() {
    System.out.print("Test setId... ");
    String idBool = "1";
    SignInModel model = new SignInModel();
    model.setId(idBool);
    String desc = model.getId();
    assertEquals(idBool, desc);
    System.out.println("OK");
  }

  /**
   * Test of setPass method, of class SignInModel.
   */
  @Test
  public void testSetPass() {
    System.out.print("Test setPass... ");
    String passw = "123";
    SignInModel model = new SignInModel();
    model.setPass(passw);
    String password = model.getPass();
    assertEquals(passw, password);
    System.out.println("OK");
  }

  /**
   * Test of setDescription method, of class SignInModel.
   */
  @Test
  public void testSetDescription() {
    System.out.print("Test setDescription... ");
    String desc = "123";
    SignInModel model = new SignInModel();
    model.setDescription(desc);
    String desc1 = model.getDescription();
    assertEquals(desc, desc1);
    System.out.println("OK");
  }
  
}
