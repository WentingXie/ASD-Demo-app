package asd.demo.model.dao;

import com.mongodb.BasicDBObject;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class OpalCardDao {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public OpalCardDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        database = mongoClient.getDatabase("heroku_bqcjmqws");
        collection = database.getCollection("OpalCardList");
    }

<<<<<<< HEAD
    public List<OpalCard> listOpalCard(String EmailAddress) {
        //initialise Array
        List<OpalCard> list = new ArrayList<>();

        for (Document doc : collection.find()) {

=======
    public List<OpalCard> listOpalCard(String EmailAddress) { // Get opalcardlist by email address
        // Initialise Array
        List<OpalCard> list = new ArrayList<>();
        // Iterate through the documents in collection
        for (Document doc : collection.find()) {
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
            if (((String) doc.get("EmailAddress")).equals(EmailAddress)) {
                // Create Opal Card
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((double) doc.get("Balance"));
<<<<<<< HEAD
                card.setDescription((String) doc.get("Description"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));
=======
                card.setDescription((String) doc.get("ProductTypeId"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
                list.add(card);
            }
        }
        return list;
    }

<<<<<<< HEAD
    public OpalCard getOpalCard(String ID) {
        for (Document doc : collection.find()) {

            if (((String) doc.get("SequenceNumber")).equals(ID)) {
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((double) doc.get("Balance"));
                card.setDescription((String) doc.get("Description"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));
=======
    public OpalCard getOpalCard(String ID) { // Get selected opal card by ID
        // Iterate through the documents in collection
        for (Document doc : collection.find()) {
            if (((String) doc.get("SequenceNumber")).equals(ID)) {
                // Create Opal Card
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((double) doc.get("Balance"));
                card.setDescription((String) doc.get("ProductTypeId"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
                return card;
            }
        }
        return null;
    }

    public void updateCard(OpalCard card) { // Update card balance by opalcard number
        BasicDBObject newDocument = new BasicDBObject();
<<<<<<< HEAD

        newDocument.append("$set", new BasicDBObject().append("Balance", card.getBalance()));
=======
        // Get the updated value
        newDocument.append("$set", new BasicDBObject().append("Balance", card.getBalance()));
        // Search for document
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
        BasicDBObject searchQuery = new BasicDBObject().append(("SequenceNumber"), card.getSequenceNumber());
        collection.updateOne(searchQuery, newDocument);
    }
}
