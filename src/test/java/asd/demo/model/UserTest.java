/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

//import asd.demo.model.dao.MongoDBConnector;
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
public class UserTest {
   
    private static MongoClient mongoClient;
    
    public UserTest() {
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
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);
        
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.print("\n<-- Unit Test Finished : "); 
        
    }
   

    
}
