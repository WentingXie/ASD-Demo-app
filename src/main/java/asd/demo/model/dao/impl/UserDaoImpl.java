package asd.demo.model.dao.impl;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import asd.demo.model.User;
import asd.demo.model.dao.IUserDao;
import asd.demo.utils.MongoDBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public User findByEmailAndPwd(String email, String userPwd) {

		System.out.println(email);
		System.out.println(userPwd);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();

			MongoCollection<Document> collection = mdb.getCollection("User");

			System.out.println(collection.count());

			BasicDBList condList = new BasicDBList();
			BasicDBObject cond1 = new BasicDBObject();
			cond1.append("EmailAddress", email);
			BasicDBObject cond2 = new BasicDBObject();
			cond2.append("Password", userPwd);
			condList.add(cond1);
			condList.add(cond2);

			BasicDBObject cond = new BasicDBObject();
			cond.put("$and", condList);
			FindIterable<Document> cursor = collection.find(cond);

			Document document = (Document) cursor.first();
			if (document == null) {
				return null;
			}

			System.out.println(document);

			User user = new User();
			user.setName(document.get("UserName").toString());
			user.setPassword(document.get("Password").toString());
			user.setPhone(document.get("PhoneNumber").toString());
			user.setEmail(document.get("EmailAddress").toString());
			user.setUserType(String.valueOf(document.get("UserType")));
			user.setAccountBalance(String.valueOf(document.get("AccountBalance")));
			System.out.println(user.toString());
			System.out.println("ok....");
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public int insertUser(User user) {

		try {

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return 0;
			}
			MongoCollection<Document> collection = mdb.getCollection("User");
			Document document = new Document("UserName", user.getName());
			document.append("Password", user.getPassword());
			document.append("AccountBalance", user.getAccountBalance());
			document.append("PhoneNumber", user.getPhone());
			document.append("EmailAddress", user.getEmail());
			document.append("UserType", "User"); // TODO default set
			collection.insertOne(document);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	@Override
	public int updateUserInfo(User newUser) {
		User oldUser = findByEmail(newUser.getEmail());
		if (oldUser == null) {
			return -1;
		}
		System.out.println("before : " + oldUser.toString());

		try {

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return 0;
			}

			MongoCollection<Document> collection = mdb.getCollection("User");
			Bson filter = Filters.eq("EmailAddress", newUser.getEmail());

			Document document = new Document("UserName", newUser.getName());
			document.append("Password", newUser.getPassword());
//			document.append("AccountBalance", newUser.getAccountBalance());
			document.append("PhoneNumber", newUser.getPhone());
//			document.append("EmailAddress", newUser.getEmail());
			document.append("UserType", newUser.getUserType());
			Document newDocument = new Document("$set", document);
			collection.updateOne(filter, newDocument);
			System.out.println(newDocument.toJson());

			oldUser = findByEmail(newUser.getEmail());
			if (oldUser == null) {
				return -1;
			}

			System.out.println("after : " + oldUser.toString());

			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public User findByEmail(String email) {
		System.out.println(email);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();

			MongoCollection<Document> collection = mdb.getCollection("User");

			BasicDBObject cond = new BasicDBObject();
			cond.append("EmailAddress", email);
			FindIterable<Document> cursor = collection.find(cond);

			Document document = (Document) cursor.first();
			if (document == null) {
				return null;
			}

			User user = new User();
			user.setName(document.get("UserName").toString());
			user.setPassword(document.get("Password").toString());
			user.setPhone(document.get("PhoneNumber").toString());
			user.setEmail(document.get("EmailAddress").toString());
			user.setUserType(String.valueOf(document.get("UserType")));
			user.setAccountBalance(String.valueOf(document.get("AccountBalance")));
			System.out.println(user.toString());
			System.out.println("ok....");
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
