package org.mgr;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mgr.models.entities.*;

import java.util.Collection;

@Slf4j
public class HibernateController {

    public void saveCollection(Collection<?> collection) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GeneralItem.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(Smartphone.class)
                .addAnnotatedClass(GraphicCard.class)
                .addAnnotatedClass(Notebook.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            collection.forEach(session::saveOrUpdate);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Hibernate fatality:\n" + e.getCause().toString());
        }
    }
}
