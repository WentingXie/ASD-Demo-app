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
public class AddBalanceTestTest {
    
    public AddBalanceTestTest() {
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
     * Test of addBalance method, of class AddBalanceTest.
     */
    @Test
    public void testAddBalance() {
        System.out.println("addBalance");
        double amount1 = 12.25;
        double amount2 = 2.25;
        AddBalanceTest instance = new AddBalanceTest();
        double expResult = 14.5;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testAddBalance2() {
        System.out.println("addBalance");
        double amount1 = 225;
        double amount2 = 225;
        AddBalanceTest instance = new AddBalanceTest();
        double expResult = 450;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testAddBalance3() {
        System.out.println("addBalance");
        double amount1 = 12.25;
        double amount2 = 0.001;
        AddBalanceTest instance = new AddBalanceTest();
        double expResult = 12.251;
        double result = instance.addBalance(amount1, amount2);
        assertEquals(expResult, result, 0.0);
    }
    
}
