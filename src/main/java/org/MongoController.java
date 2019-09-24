package org;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoController {

    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    public MongoController(final String host,
                           final int port,
                           final String databaseName) {
        this.mongoClient = new MongoClient(host, port);
        this.mongoDatabase = mongoClient.getDatabase(databaseName);
    }


    public List<Document> extractDocumentsFromCollection(String collectionName) {
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        System.out.println(mongoDatabase.getName() + "." + collection.getNamespace().getCollectionName());
        List<Document> items = new ArrayList<>();
        MongoCursor x = collection.find().cursor();
        while (x.hasNext()) {
            items.add((Document) x.next());
        }
        return items;
    }
}
