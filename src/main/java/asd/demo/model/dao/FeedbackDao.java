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
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.regex.Pattern.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FeedbackDao {

    MongoClient mongoClient;
    DB database;
    DBCollection collection;

    public FeedbackDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        database = mongoClient.getDB("heroku_bqcjmqws");
        collection = database.getCollection("Feedback");
    }

    public List<Feedback> getFeedbackList() {

        DBCursor cursor = collection.find();
        System.out.println("COUNT: " + cursor.count());
        List<Feedback> list = null;
        list = new ArrayList<>();
        int count = 0;
        while (cursor.hasNext()) {
            DBObject result = cursor.next();
            Feedback feedback = new Feedback();
            String opalCardNo = (String) result.get("opalCardNo");
            String firstName = (String) result.get("firstName");
            String lastName = (String) result.get("lastName");
            String address = (String) result.get("address");
            String street1 = (String) result.get("street1");
            String street2 = (String) result.get("street2");
            String pinCode = (String) result.get("pinCode");
            String city = (String) result.get("city");
            String state = (String) result.get("state");
            String country = (String) result.get("country");
            String email = (String) result.get("email");
            String enqueryType = (String) result.get("enqueryType");
            String enquery = (String) result.get("enquery");
            feedback.setOpalCardNo(opalCardNo);
            feedback.setFirstName(firstName);
            feedback.setLastName(lastName);
            feedback.setAddress(address);
            feedback.setStreet1(street1);
            feedback.setStreet2(street2);
            feedback.setCity(city);
            feedback.setState(state);
            feedback.setCountry(country);
            feedback.setEnquery(enquery);
            feedback.setEnqueryType(enqueryType);
            feedback.setEmail(email);
            list.add(feedback);

        }
        return list;
    }
    
        public Feedback getFeedback(String Id) {

        Feedback feedback = new Feedback();
        DBObject query = new BasicDBObject("email", Id);
             DBObject  result = collection.findOne(query);
            String opalCardNo = (String) result.get("opalCardNo");
            String firstName = (String) result.get("firstName");
            String lastName = (String) result.get("lastName");
            String address = (String) result.get("address");
            String street1 = (String) result.get("street1");
            String street2 = (String) result.get("street2");
            String pinCode = (String) result.get("pinCode");
            String city = (String) result.get("city");
            String state = (String) result.get("state");
            String country = (String) result.get("country");
            String email = (String) result.get("email");
            String enqueryType = (String) result.get("enqueryType");
            String enquery = (String) result.get("enquery");
            feedback.setOpalCardNo(opalCardNo);
            feedback.setFirstName(firstName);
            feedback.setLastName(lastName);
            feedback.setAddress(address);
            feedback.setStreet1(street1);
            feedback.setStreet2(street2);
            feedback.setCity(city);
            feedback.setState(state);
            feedback.setCountry(country);
            feedback.setEnquery(enquery);
            feedback.setEnqueryType(enqueryType);
            feedback.setEmail(email);
                return feedback;

    }
}
