/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import java.util.HashMap;
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
public class ValidatorTest {
    
    public ValidatorTest() {
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
     * Test of validateNumber method, of class Validator.
     */
    @Test
    public void testValidateNumber() {
        System.out.println("validateNumber");
        String number = "20";
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.validateNumber(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumber method, of class Validator.
     */
    @Test
    public void testValidateNumber2() {
        System.out.println("validateNumber");
        String number = "10.1";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.validateNumber(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumber method, of class Validator.
     */
    @Test
    public void testValidateNumber3() {
        System.out.println("validateNumber");
        String number = "-10";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.validateNumber(number);
        assertEquals(expResult, result);
    }
    
    


}
