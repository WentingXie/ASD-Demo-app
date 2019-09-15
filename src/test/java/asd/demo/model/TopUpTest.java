/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asd.demo.model;

import asd.demo.model.dao.UnitTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonny
 */
public class TopUpTest {
    
    public TopUpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBalance method, of class UnitTest.
     */
    @Test
    public void testAddBalance() {
        System.out.println("addBalance");
        double amount1 = 12.50;
        double amount2 = 12.50;
        UnitTest instance = new UnitTest();
        double expResult = 25;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
       @Test
    public void testAddBalance2() {
        System.out.println("addBalance");
        double amount1 = 3.3333;
        double amount2 = 3.3333;
        UnitTest instance = new UnitTest();
        double expResult = 6.6666;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
       @Test
    public void testAddBalance3() {
        System.out.println("addBalance");
        double amount1 = 12.50;
        double amount2 = 0.10;
        UnitTest instance = new UnitTest();
        double expResult = 12.6;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
}
