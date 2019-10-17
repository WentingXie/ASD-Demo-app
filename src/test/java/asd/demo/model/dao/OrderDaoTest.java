/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

import asd.demo.model.Order;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.List;
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
public class OrderDaoTest {
  private static MongoClient mongoClient;  
    public OrderDaoTest() {
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
     * Test of listOrder method, of class OrderDao.
     */
    @Test
    public void testListOrder() {
        OrderDao order = new OrderDao(mongoClient);
        List<Order> o = order.listOrder("5d7765e1d811c60caca96bd4");
         assertNotNull("Testing Order History",o);
        for(Order i:o)
            System.out.println(i);
        
        System.out.println("Order Histroy Test Succeed");
        
    }

    /**
     * Test of listActivatedOrder method, of class OrderDao.
     */
    @Test
    public void testListActivatedOrder() {
        OrderDao order = new OrderDao(mongoClient);
        List<Order> o = order.listActivatedOrder("5d7765e1d811c60caca96bd4");
         assertNotNull("Testing Order History",o);
        
           
            System.out.println("Getting the Activated Card");
             System.out.println(o);
            System.out.println("List Activated Order Test Succeed");
    }
    
}
