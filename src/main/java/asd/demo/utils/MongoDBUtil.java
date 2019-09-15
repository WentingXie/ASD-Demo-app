package asd.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

	private static MongoDBUtil mongoDBUtil;

	private MongoDBUtil() {

	}

	public static MongoDBUtil getMongoDBUtilInstance() {
		if (mongoDBUtil == null) {
			return new MongoDBUtil();
		}
		return mongoDBUtil;
	}

	@SuppressWarnings("resource")
	public MongoDatabase getConnect() {
		List<ServerAddress> adds = new ArrayList<>();

		ServerAddress serverAddress = new ServerAddress("ds023603.mlab.com", 23603);
		adds.add(serverAddress);

		List<MongoCredential> credentials = new ArrayList<>();
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("heroku_bqcjmqws",
				"heroku_bqcjmqws", "3n91u46bthugnp5ejiuvpc9fvq".toCharArray());
		credentials.add(mongoCredential);

		return new MongoClient(adds, credentials).getDatabase("heroku_bqcjmqws");

	}
}
