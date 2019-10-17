/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.Feedback;
import asd.demo.service.impl.FeedbackServiceImpl;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.name;

/**
 *
 * @author wentingxie
 */
public class FeedbackTest {
   
    private static MongoClient mongoClient;
    
    public FeedbackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String dbUrl = "ds023603.mlab.com";
	String dbPort = String.valueOf(23603);
	String dbUser = "heroku_bqcjmqws";
	String dbPass = "3n91u46bthugnp5ejiuvpc9fvq";
	String dbName = "heroku_bqcjmqws";
	String dbUri = String.format("mongodb://%s:%s@%s:%s/%s", dbUser, dbPass, dbUrl, dbPort, dbName);
	mongoClient = new MongoClient(new MongoClientURI(dbUri));
        System.out.println("\n<-- Starting test -->"); 
        
        
    }
    
   
   /*
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = "";
        String result = instance.getName();
        Assert.assertEquals(expResult, result);
        //Assert.assertNotNull(User.getName());
        Assert.assertNotNull("Cannot fetch ASD users",result);
    }
    
*/
    
    @Test
    public void testAddFeedback() {
        System.out.println("setFeedback");
        String name = "";
        FeedbackServiceImpl service = new FeedbackServiceImpl();
        Feedback feedback = new Feedback();
        feedback.setOpalCardNo("1234567894569785");
            feedback.setFirstName("jhone");
            feedback.setLastName("doe");
            feedback.setAddress("New York");
            feedback.setStreet1("#265 Lake");
            feedback.setStreet2("1256");
            feedback.setCity("NY");
            feedback.setState("NY");
            feedback.setCountry("USA");
            feedback.setEnquery("Test");
            feedback.setEnqueryType("Test");
            feedback.setEmail("jhone@gmail.com");
            double expResult = 1;
            double result = service.insertFeedback(feedback);
                 assertEquals(expResult, result, 0.0);

         
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.print("\n<-- Unit Test Finished : "); 
        
    }
   

    
}
