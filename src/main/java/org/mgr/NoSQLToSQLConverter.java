package org.mgr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.deserialization.OrderDeserializer;
import org.mgr.models.Item;
import org.mgr.models.Order;
import org.mgr.models.entities.GeneralItem;
import org.mgr.models.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NoSQLToSQLConverter {



    public void convert() {
        MongoController mongoController = new MongoController();
        List<Document> elements = mongoController.extractDocumentsFromCollection("orders");
        List<Item> items = new ArrayList<>();
        List<OrderEntity> orders = new ArrayList<>();
        elements.forEach(element -> deserializeOrder(element, orders, items));

        //hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GeneralItem.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            orders.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Hibernate fatality");
        }
    }

    private void deserializeOrder(Document element, List<OrderEntity> orders, List<Item> items) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Order.class, new OrderDeserializer())
                .create();
        orders.add(gson.fromJson(element.toJson(), OrderEntity.class));
    }
}