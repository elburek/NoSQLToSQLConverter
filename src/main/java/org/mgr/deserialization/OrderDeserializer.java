package org.mgr.deserialization;

import com.google.gson.Gson;
import org.bson.Document;
import org.mgr.models.Item;
import org.mgr.models.entities.Client;
import org.mgr.models.entities.OrderEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDeserializer {

    private final Gson gson = new Gson();
    private final ItemDeserializer itemDeserializer = new ItemDeserializer();

    public void deserialize(Document order, List<OrderEntity> orders, List<Item> items, List<Client> clients) {
        Client client = getClient(order);
        List<Item> deserializedItems = itemDeserializer.deserialize(order);
        List<OrderEntity> deserializedOrders = temp(deserializedItems, order, client.getId());
        clients.add(client);
        items.addAll(deserializedItems);
        orders.addAll(deserializedOrders);
    }

    private Client getClient(Document order) {
        return gson.fromJson(gson.toJson(order.get("client")), Client.class);
    }

    private List<OrderEntity> temp(List<Item> deserializedItems, Document order, Integer clientId) {
        return deserializedItems.stream()
                .map(deserializedItem -> buildOrderEntity(order, clientId, deserializedItem.getId()))
                .collect(Collectors.toList());
    }

    private OrderEntity buildOrderEntity(Document order, Integer clientId, Integer itemId) {
        return OrderEntity.builder()
                .orderId(order.getInteger("id"))
                .clientId(clientId)
                .deliveryAddress(order.getString("deliveryAddress"))
                .date(new Timestamp(order.getLong("timestamp")))
                .itemId(itemId)
                .build();
    }
}