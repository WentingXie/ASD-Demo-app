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

    public List<OpalCard> listOpalCard(String EmailAddress) {
        //initialise Array
        List<OpalCard> list = new ArrayList<>();

        for (Document doc : collection.find()) {

            if (((String) doc.get("EmailAddress")).equals(EmailAddress)) {
                // Create Opal Card
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((double) doc.get("Balance"));
                card.setDescription((String) doc.get("ProductTypeId"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));
                list.add(card);
            }
        }
        return list;
    }

    public OpalCard getOpalCard(String ID) {
        for (Document doc : collection.find()) {

            if (((String) doc.get("SequenceNumber")).equals(ID)) {
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((double) doc.get("Balance"));
                card.setDescription((String) doc.get("ProductTypeId"));
                card.setSequenceNumber((String) doc.get("SequenceNumber"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));
                return card;
            }
        }
        return null;
    }

    public void updateCard(OpalCard card) {

        BasicDBObject newDocument = new BasicDBObject();

        newDocument.append("$set", new BasicDBObject().append("Balance", card.getBalance()));
        BasicDBObject searchQuery = new BasicDBObject().append(("SequenceNumber"), card.getSequenceNumber());
        collection.updateOne(searchQuery, newDocument);
    }
}
