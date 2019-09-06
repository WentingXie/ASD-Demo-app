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

public class OrderDao {
	MongoClient mongoClient;
	DB database;
	DBCollection collection;

	public OrderDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;

		database = mongoClient.getDB("heroku_bqcjmqws");
		collection = database.getCollection("order");
	}
