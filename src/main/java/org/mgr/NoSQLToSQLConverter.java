package org.mgr;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.deserialization.OrderDeserializer;
import org.mgr.models.Item;
import org.mgr.models.entities.*;

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

        //hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GeneralItem.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(Smartphone.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            orders.forEach(session::saveOrUpdate);
            items.forEach(session::saveOrUpdate);
            clients.forEach(session::saveOrUpdate);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Hibernate fatality");
        }
    }
}