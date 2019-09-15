/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.test;

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
public class AddBalanceTest {
    
    public AddBalanceTest() {
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
     * Test of addBalance method, of class AddBalance.
     */
    @Test
    public void testAddBalance() {
        System.out.println("addBalance");
        double amount1 = 12.25;
        double amount2 = 13.25;
        AddBalance instance = new AddBalance();
        double expResult = 25.5;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testAddBalance2() {
        System.out.println("addBalance");
        double amount1 = 0.23;
        double amount2 = 0.77;
        AddBalance instance = new AddBalance();
        double expResult = 1;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testAddBalance3() {
        System.out.println("addBalance");
        double amount1 = 100;
        double amount2 = 0.25;
        AddBalance instance = new AddBalance();
        double expResult = 100.25;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
}
