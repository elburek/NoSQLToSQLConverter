package org.mgr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.models.entities.Item;

import java.util.List;

@Slf4j
public class NoSQLToSQLConverter {

    private final Config config = new Config();

    public void convert() {
        MongoController mongoController = new MongoController(config.getMongoHost(), config.getMongoPort(), config.getMongoDatabaseName());
        List<Document> items = mongoController.extractDocumentsFromCollection("items");
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Item.class, new ItemDeserializer())
                .create();
        Item item = gson.fromJson(items.get(0).append("dupa", "dupa2").toJson(), Item.class);
        //hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Hibernate fatality");
        }
    }
}
