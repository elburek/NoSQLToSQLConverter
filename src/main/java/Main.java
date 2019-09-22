import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import models.Item;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("MGR");
        MongoCollection collection = mongoDatabase.getCollection("items");
        System.out.println(mongoDatabase.getName() + "." + collection.getNamespace().getCollectionName());
        List<Document> items = extractListFromCollection(collection);
        System.out.println("done");
        Gson gson = new Gson();
        Item item = gson.fromJson(items.get(0).append("dupa","dupa2").toJson(), Item.class);
        System.out.println("2");

    }

    private static List<Document> extractListFromCollection(MongoCollection collection) {
        List<Document> items = new ArrayList<>();
        MongoCursor x = collection.find().cursor();
        while (x.hasNext()) {
            items.add((Document)x.next());
        }
        return items;
    }
}
