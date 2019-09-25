package org.mgr.deserialization;

import com.google.gson.Gson;
import org.bson.Document;
import org.mgr.Category;
import org.mgr.models.Item;
import org.mgr.models.entities.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDeserializer {

    private final Gson gson = new Gson();

    public void deserialize(Document order, List<OrderEntity> orders, List<Item> items, List<Client> clients) {
        Client client = gson.fromJson(gson.toJson(order.get("client")), Client.class);
        clients.add(client);
        List<Document> rawItems = (ArrayList) order.get("items");
        rawItems.forEach(rawItem -> items.add(deserializeItem(rawItem, order.getInteger("id"))));
        items.forEach(item -> orders.add(buildOrderEntity(order, client.getId(), item.getId())));
    }

    private Item deserializeItem(Document rawItem, Integer orderId) {
        Item item;
        switch (Category.valueOf(rawItem.getString("category"))) {
            case SMARTPHONE:
                item = gson.fromJson(rawItem.toJson(), Smartphone.class);
                break;
            case CAR:
                item = gson.fromJson(rawItem.toJson(), Car.class);
                break;
            default:
                item = gson.fromJson(rawItem.toJson(), GeneralItem.class);
                break;
        }
        item.setId(orderId);
        return item;
    }

    private OrderEntity buildOrderEntity(Document order, Integer clientId, Integer itemId) {
        return OrderEntity.builder()
                .id(order.getInteger("id"))
                .clientId(clientId)
                .deliveryAddress(order.getString("deliverAddress"))
                .date(new Timestamp(order.getLong("timestamp")))
                .itemId(itemId)
                .build();
    }
}