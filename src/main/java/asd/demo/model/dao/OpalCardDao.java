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
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.regex.Pattern.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class OpalCardDao {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public OpalCardDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        database = mongoClient.getDatabase("heroku_bqcjmqws");
        collection = database.getCollection("Opal-Card");
    }

    public List<OpalCard> listOpalCard() {

        // Initialise Array
        List<OpalCard> list = new ArrayList<>();

        for (Document doc : collection.find()) {

            // Create Opal Card
            OpalCard card = new OpalCard();
            card.setOpalCardID((String) doc.get("SequenceNumber"));
            card.setBalance(new BigDecimal((String) doc.get("Price")));
            card.setDescription((String) doc.get("ProductTypeId"));
            //card.setSecurityNumber((String)doc.get("SecurityNumber"));

            // Add card to list
            list.add(card);
        }

        // Return List
        return list;
    }

    public OpalCard getOpalCard(String ID) {

        for (Document doc : collection.find()) {
            if (((String) doc.get("SequenceNumber")).equals(ID)) {
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("SequenceNumber"));
                card.setBalance(new BigDecimal((String) doc.get("Price")));
                card.setDescription((String) doc.get("ProductTypeId"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));

                return card;
            }
        }
        return null;
    }

    public void updateCard(OpalCard card) {
        Document condition = new Document();
        condition.append("SequenceNumber", card.getOpalCardID());
        
        Document update = new Document();
        update.append("Price", card.getBalance());
        
       collection.updateOne(condition, update);
    }
}
