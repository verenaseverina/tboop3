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
public class RecordTest {
  
  public RecordTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Record Test");
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
   * Test of setDate method, of class Record.
   */
  @Test
  public void testSetDate() {
    System.out.print("Test setDate... ");
    String tgl = "10/07/1997";
    Record rec = new Record("", "10", "","");
    rec.setDate(tgl);
    assertEquals(rec.getDate(), tgl);
    System.out.println("OK");
  }

  /**
   * Test of setAmount method, of class Record.
   */
  @Test
  public void testSetAmount() {
    System.out.print("Test setAmount... ");
    String amount = "10000";
    Record rec = new Record("", "10", "","");
    rec.setAmount(amount);
    assertEquals(rec.getAmount(), 10000);
    System.out.println("OK");
  }

  /**
   * Test of setCategory method, of class Record.
   */
  @Test
  public void testSetCategory() {
    System.out.print("Test setCategory... ");
    String category = "Makanan";
    Record rec = new Record("", "10", "","");
    rec.setCategory(category);
    assertEquals(rec.getCategory(), category);
    System.out.println("OK");
  }

  /**
   * Test of setDescription method, of class Record.
   */
  @Test
  public void testSetDescription() {
    System.out.print("Test setDescription... ");
    String description = "testtesttest";
    Record rec = new Record("", "10", "","");
    rec.setDescription(description);
    assertEquals(rec.getDescription(), description);
    System.out.println("OK");
  }

  /**
   * Test of getDate method, of class Record.
   */
  @Test
  public void testGetDate() {
    System.out.print("Test getDate... ");
    String tgl = "10/07/1997";
    Record rec = new Record("", "10", "","");
    rec.setDate(tgl);
    assertEquals(rec.getDate(), tgl);
    System.out.println("OK");
  }

  /**
   * Test of getAmount method, of class Record.
   */
  @Test
  public void testGetAmount() {
    System.out.print("Test getAmount... ");
    String amount = "10000";
    Record rec = new Record("", "10", "","");
    rec.setAmount(amount);
    assertEquals(rec.getAmount(), 10000);
    System.out.println("OK");
  }

  /**
   * Test of getCategory method, of class Record.
   */
  @Test
  public void testGetCategory() {
    System.out.print("Test getCategory... ");
    String category = "Makanan";
    Record rec = new Record("", "10", "","");
    rec.setCategory(category);
    assertEquals(rec.getCategory(), category);
    System.out.println("OK");
  }

  /**
   * Test of getDescription method, of class Record.
   */
  @Test
  public void testGetDescription() {
    System.out.print("Test getDescription... ");
    String description = "testtesttest";
    Record rec = new Record("", "10", "","");
    rec.setDescription(description);
    assertEquals(rec.getDescription(), description);
    System.out.println("OK");
  }
  
}
