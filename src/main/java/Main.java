import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import models.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("MGR");
        MongoCollection amazon = mongoDatabase.getCollection("Amazon");
//        List<DBObject> all = new List<DBObject>();
        List<DBObject> list = new ArrayList<>();
        amazon.find().into(list);
        System.out.println("Method 1:");
        System.out.println(list);
        System.out.println("Method 2:");
        MongoCursor x = amazon.find().cursor();
        while (x.hasNext()) {
            System.out.println(x.next());
        }
    }
}
