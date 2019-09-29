package org.mgr;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.mgr.deserialization.OrderDeserializer;
import org.mgr.models.entities.Client;
import org.mgr.models.entities.Item;
import org.mgr.models.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NoSQLToSQLConverter {

    private final MongoController mongoController = new MongoController();
    private final OrderDeserializer orderDeserializer = new OrderDeserializer();
    private final HibernateController hibernateController = new HibernateController();

    public void convert() {
        log.info("Starting convertion.");
        List<Document> elements = mongoController.extractDocumentsFromCollection("orders");
        List<Item> items = new ArrayList<>();
        List<OrderEntity> orders = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        elements.forEach(element -> orderDeserializer.deserialize(element, orders, items, clients));
        hibernateController.saveCollection(items);
        hibernateController.saveCollection(orders);
        hibernateController.saveCollection(clients);
    }
}