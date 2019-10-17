package asd.demo.model.dao;

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

    public List<PaymentHistory> listPaymentHistory(String EmailAddress) { // Get paymenthistorylist by email address
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

    public List<PaymentHistory> listPaymentHistoryByNumber(String EmailAddress, String Search) { // Get paymenthistorylist by email address and search
        //initialise Array
        List<PaymentHistory> list = new ArrayList<>();
        for (Document doc : collection.find()) {
        String search = Search;
        if (search == null) search = "";
            if (((String) doc.get("EmailAddress")).equals(EmailAddress) && ((String) doc.get("SequenceNumber")).contains(search)) {
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

    public void addHistory(String sequenceNumber, double amount, String timeStamp, String emailAddress) { // Add payment history after user top up
        Document doc = new Document();
        doc.put("SequenceNumber", sequenceNumber);
        doc.put("Amount", amount);
        doc.put("TimeStamp", timeStamp);
        doc.put("EmailAddress", emailAddress);
        collection.insertOne(doc);
    }

    public void deleteHistory(String id) { // Delete history by ID
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    public void deleteAll() { // Clear paymenthistory page
        BasicDBObject document = new BasicDBObject();
        collection.deleteMany(document);
    }

}

