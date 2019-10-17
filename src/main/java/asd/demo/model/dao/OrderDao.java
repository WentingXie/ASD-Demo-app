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
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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
				// Create Order
					Order order = new Order();
                                        //Setup Order attributes
				order.setOpalCardSequenceNumber((String)doc.get("OpalCardSequenceNumber"));
				order.setUserAddress((String)doc.get("UserAddress"));
                                order.setOrderDate((String)doc.get("OrderDate"));
                                order.setProductTypeId((String)doc.get("ProductTypeId"));
                                order.setStatus((String)doc.get("Status"));
				// card.setSecurityNumber((String)doc.get("SecurityNumber"));
				list.add(order);
                            
				// card.setSecurityNumber((String)doc.get("SecurityNumber"));
				
			}
		}
		return list;
	}
        public List<Order> listActivatedOrder(String UserID) {
            // initialise Array
            List<Order> list = new ArrayList<>();

            for (Document doc : collection.find()) {
                    //get order for activated card from login user
                    if (((String) doc.get("UserId")).equals(UserID) && doc.get("Status").toString().equals("1")) {
                            // Create Order
                            Order order = new Order();
                            //Setup Order attributes
                            order.setId(doc.get("_id").toString());
                            order.setOpalCardSequenceNumber((String)doc.get("OpalCardSequenceNumber"));
                            order.setUserAddress((String)doc.get("UserAddress"));
                            order.setOrderDate((String)doc.get("OrderDate"));

                            // card.setSecurityNumber((String)doc.get("SecurityNumber"));
                            list.add(order);
                    }
            }
            return list;
	}
        //Deavtivate Card
        public void DeactivateOrde(String id) {
            ObjectId _idobj = null;
            //Get login User ID
            _idobj = new ObjectId(id);
            Bson filter = Filters.eq("_id", _idobj);
            // Set up the status to 0(Deactivate)
            Document document = new Document("Status", "0");
            Document newDocument = new Document("$set", document);
            collection.updateOne(filter, newDocument);
        }
}
