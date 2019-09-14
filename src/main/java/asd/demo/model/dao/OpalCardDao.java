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
import javax.servlet.http.HttpSession;
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
            card.setOpalCardID((String) doc.get("_id").toString());
            card.setBalance((Integer) doc.get("Price"));
            card.setDescription((String) doc.get("ProductTypeId"));
            //card.setSecurityNumber((String)doc.get("SecurityNumber"));

            // Add card to list
            list.add(card);
        }

        // Return List
        return list;
    }

    public List<OpalCard> listOpalCard2(String EmailAddress) {

        //initialise Array
        List<OpalCard> list2 = new ArrayList<>();

        for (Document doc : collection.find()) {
            // Create Opal Card
                OpalCard card = new OpalCard();
                
            if (((String) doc.get("EmailAddress")).equals(EmailAddress)) {

                
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((Integer) doc.get("Price"));
                card.setDescription((String) doc.get("ProductTypeId"));
                
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));

                list2.add(card);
        }    
        }
            // Return List
            return list2;
        }
       
    

    public OpalCard getOpalCard(String ID) {

        for (Document doc : collection.find()) {
            if (((String) doc.get("_id").toString()).equals(ID)) {
                OpalCard card = new OpalCard();
                card.setOpalCardID((String) doc.get("_id").toString());
                card.setBalance((Integer) doc.get("Price"));
                card.setDescription((String) doc.get("ProductTypeId"));
                //card.setSecurityNumber((String)doc.get("SecurityNumber"));

                return card;
            }
        }
        return null;
    }

    public void updateCard(OpalCard card) {

        BasicDBObject newDocument = new BasicDBObject();

        newDocument.append("$set", new BasicDBObject().append("Price", card.getBalance()));

        BasicDBObject searchQuery = new BasicDBObject().append(("sequenceNumber"), card.getSequenceNumber());

        collection.updateOne(searchQuery, newDocument);
    }
}
