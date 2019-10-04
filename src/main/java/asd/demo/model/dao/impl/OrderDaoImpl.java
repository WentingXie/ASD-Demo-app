package asd.demo.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import asd.demo.model.Order;
import asd.demo.model.dao.IOrderDao;
import asd.demo.utils.MongoDBUtil;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public int insertOrder(Order order) {
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return 0;
			}
			MongoCollection<Document> collection = mdb.getCollection("Order");
			Document document = new Document("UserId", order.getUserId());
			document.append("ProductTypeId", order.getProductTypeId());
			document.append("OpalCardSequenceNumber", order.getOpalCardSequenceNumber());
			document.append("OrderDate", order.getOrderDate());
			document.append("UserAddress", order.getUserAddress());
			document.append("Postal Code", order.getPostalCode());
			document.append("Status", "0");
			collection.insertOne(document);
			return 1;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return 0;
		}
	}

	@Override
	public int updateOrderInfo(Order Order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> findOrdersByUserIdAndSequenceNumberAndStatus(String userId, String sequenceNumber,
			String status) {
		List<Order> orderList = new ArrayList<Order>();
		System.out.println("userId" + userId);
		System.out.println("sequenceNumber" + userId);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return new ArrayList<Order>();
			}
			MongoCollection<Document> collection = mdb.getCollection("Order");

			BasicDBList condList = new BasicDBList();
			BasicDBObject cond1 = new BasicDBObject();

			cond1.append("UserId", userId);
			condList.add(cond1);

			if (sequenceNumber != null) {
				BasicDBObject cond2 = new BasicDBObject();
				cond2.append("OpalCardSequenceNumber", sequenceNumber);
				condList.add(cond2);
			}
			if (status != null) {
				BasicDBObject cond2 = new BasicDBObject();
				cond2.append("Status", status);
				condList.add(cond2);
			}

			BasicDBObject cond = new BasicDBObject();
			cond.put("$and", condList);
			FindIterable<Document> cursor = collection.find(cond);

			for (Document document : cursor) {
				Order order = new Order();
				order.setId(document.get("_id").toString());
				order.setUserId(document.get("UserId").toString());
				order.setProductTypeId(document.get("ProductTypeId").toString());
				order.setOpalCardSequenceNumber(document.get("OpalCardSequenceNumber").toString());
				order.setOrderDate(document.get("OrderDate").toString());
				order.setUserAddress(document.get("UserAddress").toString());
				order.setPostalCode(document.get("Postal Code").toString());
				order.setStatus(document.get("Status").toString());
				orderList.add(order);
			}

			return orderList;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return new ArrayList<Order>();
		}

	}

	@Override
	public int updateOrderStatus(Order order) {
		try {

			System.out.println("updateOrderStatus" + order);

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return 0;
			}

			MongoCollection<Document> collection = mdb.getCollection("Order");

			ObjectId _idobj = null;
			_idobj = new ObjectId(order.getId());
			Bson filter = Filters.eq("_id", _idobj);

			Document document = new Document("Status", "1");

			Document newDocument = new Document("$set", document);
			collection.updateOne(filter, newDocument);
			System.out.println(newDocument.toJson());
			return 1;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return 0;
		}
	}

	@Override
	public List<String> findOrdersTypesByUserId(String userId) {
		List<String> types = new ArrayList<String>();
		System.out.println("userId" + userId);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return new ArrayList<String>();
			}
			MongoCollection<Document> collection = mdb.getCollection("Order");

			BasicDBList condList = new BasicDBList();
			BasicDBObject cond1 = new BasicDBObject();

			cond1.append("UserId", userId);
			condList.add(cond1);

			BasicDBObject cond = new BasicDBObject();
			cond.put("$and", condList);
			DistinctIterable<String> cursor = collection.distinct("ProductTypeId", cond, String.class);

			for (String type : cursor) {
				types.add(type);
			}

			return types;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return new ArrayList<String>();
		}
	}
}
