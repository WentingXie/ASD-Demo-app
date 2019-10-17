/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

/**
 *
 * @author suyixin
 */
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.regex.Pattern.*;
import org.bson.types.ObjectId;

public class UserDao {

    MongoClient mongoClient;
    DB database;
    DBCollection collection;

    public UserDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        database = mongoClient.getDB("heroku_bqcjmqws");
        collection = database.getCollection("user");
    }

    public User[] getUsers() {

        DBCursor cursor = collection.find();
        System.out.println("COUNT: " + cursor.count());
        User[] user = new User[cursor.count()];
        int count = 0;
        while (cursor.hasNext()) {
            DBObject result = cursor.next();
            ObjectId userId = (ObjectId) result.get("_id");

            String name = (String) result.get("name");
            String password = (String) result.get("password");
            String email = (String) result.get("email");

            count++;
        }
        return user;
    }

    public ArrayList<User> getUsersList() {

        DBCursor cursor = collection.find();
        System.out.println("COUNT: " + cursor.count());
        ArrayList<User> users = new ArrayList<>();
        int count = 0;
        while (cursor.hasNext()) {
            DBObject result = cursor.next();
            ObjectId userId = (ObjectId) result.get("_id");

            String name = (String) result.get("name");
            String password = (String) result.get("password");
            String email = (String) result.get("email");
            String accountBalance = (String) result.get("accountBalance");
            String userType = (String) result.get("userType");
            String phone = (String) result.get("phone");

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setAccountBalance(accountBalance);
            user.setUserType(userType);
            users.add(user);

        }
        return users;
    }

//    public User getUser(String emailId) {
//
//        User user = new User();
//           DBObject query = new BasicDBObject("email", emailId);
//             DBObject  result = collection.findOne(query);
//                ObjectId userId = (ObjectId) result.get("_id");
//                String name = (String) result.get("name");
//                String password = (String) result.get("password");
//                String email = (String) result.get("email");
//                String accountBalance = (String) result.get("accountBalance");
//                String userType = (String) result.get("userType");
//                String phone = (String) result.get("phone");
//
//                user.setName(name);
//                user.setEmail(email);
//                user.setPhone(phone);
//                user.setAccountBalance(accountBalance);
//                user.setUserType(userType);
//
//        return user;
//    }
}
