/*
 * Author: Georges Bou Ghantous
 *
 * This class provides the methods to establish connection between ASD-Demo-app
 * and MongoDBLab cloud Database. The data is saved dynamically on mLab cloud database as
 * as JSON format.
 */
package asd.demo.model.dao;

import java.net.UnknownHostException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.*;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnector {

	MongoClient mongoClient;

	public MongoDBConnector() throws UnknownHostException {
		String dbUrl = "ds023603.mlab.com";
		String dbPort = String.valueOf(23603);
		String dbUser = "heroku_bqcjmqws";
		String dbPass = "3n91u46bthugnp5ejiuvpc9fvq";
		String dbName = "heroku_bqcjmqws";
		String dbUri = String.format("mongodb://%s:%s@%s:%s/%s", dbUser, dbPass, dbUrl, dbPort, dbName);
		mongoClient = new MongoClient(new MongoClientURI(dbUri));
	}

	public MongoClient openConnection() {
		return this.mongoClient;
	}

	public void closeConnection() {
		mongoClient.close();
	}
}
