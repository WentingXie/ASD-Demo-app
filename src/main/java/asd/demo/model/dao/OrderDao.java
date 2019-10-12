/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

/**
 *
 * @author suyixin
 */
import com.mongodb.BasicDBObject;
import asd.demo.model.Order;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class OrderDao {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public OrderDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        database = mongoClient.getDatabase("heroku_bqcjmqws");
        collection = database.getCollection("Order");
    }

    public List<Order> listOrder(String UserID) {
        // initialise Array
        List<Order> list = new ArrayList<>();

        for (Document doc : collection.find()) {

            if (((String) doc.get("UserId")).equals(UserID)) {
                // Create Opal Card
                Order order = new Order();
                order.setOpalCardSequenceNumber((String) doc.get("OpalCardSequenceNumber"));
                order.setUserAddress((String) doc.get("UserAddress"));
                order.setOrderDate((String) doc.get("OrderDate"));
                order.setProductTypeId((String) doc.get("ProductTypeId"));
                order.setStatus((String) doc.get("Status"));
                // card.setSecurityNumber((String)doc.get("SecurityNumber"));
                list.add(order);
            }
        }
        return list;
    }

public List<Order> listActivatedOrder(String UserID) {
            // initialise Array
            List<Order> list = new ArrayList<>();

            for (Document doc : collection.find()) {

                    if (((String) doc.get("UserId")).equals(UserID) && doc.get("Status").toString().equals("1")) {
                            // Create Opal Card
                            Order order = new Order();
                            order.setOpalCardSequenceNumber((String)doc.get("OpalCardSequenceNumber"));
                            order.setUserAddress((String)doc.get("UserAddress"));
                            order.setOrderDate((String)doc.get("OrderDate"));

                            // card.setSecurityNumber((String)doc.get("SecurityNumber"));
                            list.add(order);
                    }
            }
            return list;
	}
}
