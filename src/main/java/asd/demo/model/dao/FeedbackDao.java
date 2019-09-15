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
                        
			String name = (String) result.get("name");
			String email = (String) result.get("email");
			String title = (String) result.get("title");
			String description = (String) result.get("description");
                       feedback.setName(name);
                       feedback.setTitle(title);
                       feedback.setDescription(description);
                       feedback.setEmail(email);
                       list.add(feedback);
			
		}
		return list;
	}
}
