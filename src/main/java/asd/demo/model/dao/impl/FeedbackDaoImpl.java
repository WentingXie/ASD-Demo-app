package asd.demo.model.dao.impl;

import asd.demo.model.Feedback;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import asd.demo.model.User;
import asd.demo.model.dao.IFeedbackDao;
import asd.demo.utils.MongoDBUtil;
import com.mongodb.client.MongoCursor;

public class FeedbackDaoImpl implements IFeedbackDao {

    @Override
    public int insertFeedback(Feedback feedback) {
        try {

            MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
            if (mdb == null) {
                // connect failed
                return 0;
            }
            MongoCollection<Document> collection = mdb.getCollection("Feedback");
            Document document = new Document();
            document.append("name", feedback.getName());
            document.append("title", feedback.getTitle());
            document.append("description", feedback.getDescription());
            document.append("email", feedback.getEmail());
            collection.insertOne(document);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int deleteFeedback(String email) {
        try {

            MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
            if (mdb == null) {
                // connect failed
                return 0;
            }
            MongoCollection<Document> collection = mdb.getCollection("Feedback");
            Bson filter = Filters.eq("email", email);
            collection.deleteOne(filter);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

//    @Override
//    public Feedback[] getFeedbackList() {
//               	try {
//
//			MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
//			if (mdb == null) {
//				// connect failed
//				return null;
//			}
//			MongoCollection<Document> collection = mdb.getCollection("Feedback");
//                        collection.find();
//                        Filterble<Document> document= collection.find();
//			return (Feedback)
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//    }
    @Override
    public Feedback[] getFeedbackList() {
        MongoCursor<Document> cursor = null;
        try {
            MongoDatabase mdb = MongoDBUtil.getMongoDBUtilInstance().getConnect();
            if (mdb == null) {
                // connect failed
                return null;
            }
            MongoCollection<Document> collection = mdb.getCollection("Feedback");

            cursor = collection.find().iterator();

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
