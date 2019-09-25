package org.mgr;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.deserialization.OrderDeserializer;
import org.mgr.models.Item;
import org.mgr.models.entities.Client;
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
        List<Client> clients = new ArrayList<>();
        OrderDeserializer orderDeserializer = new OrderDeserializer();
        elements.forEach(element -> orderDeserializer.deserialize(element, orders, items, clients));


        //TODO all this shit to MySQL
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
}