package asd.demo.model.dao.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import asd.demo.model.OpalCard;
import asd.demo.model.dao.IOpalCardDao;
import asd.demo.utils.MongoDBUtil;

public class OpalCardImpl implements IOpalCardDao {

	@Override
	public OpalCard findOpalCardBySequenceAndSecurityNumber(String sequenceNumber, String securityNumber) {
		System.out.println(sequenceNumber);
		System.out.println(securityNumber);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();

			MongoCollection<Document> collection = mdb.getCollection("OpalCardList");

			BasicDBList condList = new BasicDBList();
			BasicDBObject cond1 = new BasicDBObject();
			cond1.append("SequenceNumber", sequenceNumber);
			condList.add(cond1);
			if (securityNumber != null) {
				BasicDBObject cond2 = new BasicDBObject();
				cond2.append("SecurityNumber", securityNumber);
				condList.add(cond2);
			}

			BasicDBObject cond = new BasicDBObject();
			cond.put("$and", condList);
			FindIterable<Document> cursor = collection.find(cond);

			Document document = (Document) cursor.first();
			if (document == null) {
				return null;
			}
//			System.out.println(document);
			OpalCard oc = new OpalCard();
			oc.setId(document.get("_id").toString());
			oc.setProductTypeId(document.get("ProductTypeId").toString());
			// oc.setBalance(document.get("Balance").toString());
			oc.setSequenceNumber(document.get("SequenceNumber").toString());
			oc.setSecurityNumber(document.get("SecurityNumber").toString());
			oc.setStatus(document.get("Status").toString());
//			System.out.println(oc.toString());
//			System.out.println("ok....");
			return oc;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return null;
		}

	}

	@Override
	public OpalCard getOneOpalCardByProducTypeId(String productTypeId) {
		System.out.println(productTypeId);
		try {
			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();

			MongoCollection<Document> collection = mdb.getCollection("OpalCardList");

			BasicDBList condList = new BasicDBList();
			BasicDBObject cond1 = new BasicDBObject();
			cond1.append("Status", 0); // just select unsaled opalcard。
			condList.add(cond1);

			BasicDBObject cond2 = new BasicDBObject();
			cond2.append("ProductTypeId", productTypeId);
			condList.add(cond2);

			BasicDBObject cond = new BasicDBObject();
			cond.put("$and", condList);

			FindIterable<Document> cursor = collection.find(cond);

			Document document = (Document) cursor.first();
			if (document == null) {
				return null;
			}

			OpalCard oc = new OpalCard();
			oc.setId(document.get("_id").toString());
			oc.setProductTypeId(document.get("ProductTypeId").toString());
			oc.setSequenceNumber(document.get("SequenceNumber").toString());
			oc.setSecurityNumber(document.get("SecurityNumber").toString());
			oc.setStatus(document.get("Status").toString());
			return oc;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return null;
		}
	}

	@Override
	public int updateOpalCardStatusById(String id, int status) {

		OpalCard oc = findOpalCardById(id);
		if (oc == null) {
			return -1;
		}

		try {

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return 0;
			}

			MongoCollection<Document> collection = mdb.getCollection("OpalCardList");

			ObjectId _idobj = null;
			_idobj = new ObjectId(oc.getId());

			Bson filter = Filters.eq("_id", _idobj);

			Document document = new Document("Status", status);
			Document newDocument = new Document("$set", document);
			collection.updateOne(filter, newDocument);

			return 1;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return 0;
		}

	}

	@Override
	public OpalCard findOpalCardById(String id) {
		try {

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return null;
			}

			MongoCollection<Document> collection = mdb.getCollection("OpalCardList");

			BasicDBObject cond1 = new BasicDBObject();
			cond1.append("_id", new ObjectId(id));

			FindIterable<Document> cursor = collection.find(cond1);

			Document document = (Document) cursor.first();
			if (document == null) {
				return null;
			}
			OpalCard oc = new OpalCard();
			oc.setId(document.get("_id").toString());
			oc.setProductTypeId(document.get("ProductTypeId").toString());
			oc.setSequenceNumber(document.get("SequenceNumber").toString());
			oc.setSecurityNumber(document.get("SecurityNumber").toString());
			oc.setStatus(document.get("Status").toString());
			return oc;
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return null;
		}
	}

	/**
	 * just for test
	 */
	@Override
	public String updateAllOpalCardsStatus() {
		try {

			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
			if (mdb == null) {
				// connect failed
				return null;
			}

			MongoCollection<Document> collection = mdb.getCollection("OpalCardList");

			FindIterable<Document> cursor = collection.find();

			for (Document document : cursor) {
				updateOpalCardStatusById(document.get("_id").toString(), 0);
			}
			return "ok";
		} catch (Exception e) {
			System.out.println("exception : " + e.toString());
			return null;
		}

	}
}
