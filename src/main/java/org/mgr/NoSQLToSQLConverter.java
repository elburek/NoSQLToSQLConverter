package org.mgr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.models.entities.GeneralItem;

import java.util.List;

@Slf4j
public class NoSQLToSQLConverter {



    public void convert() {
        MongoController mongoController = new MongoController();
        List<Document> elements = mongoController.extractDocumentsFromCollection("generalItems");
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(GeneralItem.class, new ItemDeserializer())
                .create();
        GeneralItem element = gson.fromJson(elements.get(0).append("dupa", "dupa2").toJson(), GeneralItem.class);
        //hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GeneralItem.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Hibernate fatality");
        }
    }
}
