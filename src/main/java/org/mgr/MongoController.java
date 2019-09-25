package org.mgr;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MongoController {

    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;
    private final Config config = new Config();

    public MongoController() {
        this.mongoClient = new MongoClient(config.getMongoHost(), config.getMongoPort());
        this.mongoDatabase = mongoClient.getDatabase(config.getMongoDatabaseName());
    }

    public List<Document> extractDocumentsFromCollection(String collectionName) {
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        log.info("Reading database: {}, collection {}", mongoDatabase.getName(), collection.getNamespace().getCollectionName());
        List<Document> items = new ArrayList<>();
        MongoCursor x = collection.find().cursor();
        while (x.hasNext()) {
            items.add((Document) x.next());
        }
        return items;
    }
}
