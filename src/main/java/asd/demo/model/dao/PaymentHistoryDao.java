/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

/**
 *
 * @author jonny lie
 */
import com.mongodb.BasicDBObject;
import asd.demo.model.PaymentHistory;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PaymentHistoryDao {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public PaymentHistoryDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        database = mongoClient.getDatabase("heroku_bqcjmqws");
        collection = database.getCollection("PaymentHistoryList");
    }

    public List<PaymentHistory> listPaymentHistory(String EmailAddress) {
        //initialise Array
        List<PaymentHistory> list = new ArrayList<>();

        for (Document doc : collection.find()) {

            if (((String) doc.get("EmailAddress")).equals(EmailAddress)) {
                // Create Opal Card
                PaymentHistory history = new PaymentHistory();
                history.setId((String) doc.get("_id").toString());
                history.setOpalCardSequenceNumber((String) doc.get("SequenceNumber"));
                history.setTopUpAmount((double) doc.get("Amount"));
                history.setTimeStamp((String) doc.get("TimeStamp"));
                list.add(history);
            }
        }
        return list;
    }

    public void addHistory(String sequenceNumber, double amount, String timeStamp, String emailAddress) {

        Document doc = new Document();
        doc.put("SequenceNumber", sequenceNumber);
        doc.put("Amount", amount);
        doc.put("TimeStamp", timeStamp);
        doc.put("EmailAddress", emailAddress);
        collection.insertOne(doc);
    }

    public void deleteHistory(String id) {

        collection.deleteOne(new Document("_id", new ObjectId(id)));

    }

    public void deleteAll() {

        BasicDBObject document = new BasicDBObject();

        collection.deleteMany(document);

    }

}
