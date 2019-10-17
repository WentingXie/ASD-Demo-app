/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author suyixin
 */
public class MongoDBConnectorTest {
private static MongoClient mongoClient;


    public MongoDBConnectorTest() {
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


    /**
     * Test of openConnection method, of class MongoDBConnector.
     */
    @Test
    public void testOpenConnection() {

        assertNotNull("Connecting to MongoDB",mongoClient);
         System.out.println("\n- Connection success ");
    }

    /**
     * Test of closeConnection method, of class MongoDBConnector.
     */
    @AfterClass
    public static void tearDownClass() {
    System.out.print("\n<-- Test Finished");
} 

}
