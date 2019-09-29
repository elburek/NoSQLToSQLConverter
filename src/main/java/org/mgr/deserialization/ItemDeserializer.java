package org.mgr.deserialization;

import com.google.gson.Gson;
import org.bson.Document;
import org.mgr.Category;
import org.mgr.models.Item;
import org.mgr.models.entities.Car;
import org.mgr.models.entities.GeneralItem;
import org.mgr.models.entities.Smartphone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDeserializer {

    private final Gson gson = new Gson();

    public List<Item> deserialize(Document order) {
        List<Document> rawItems = (ArrayList) order.get("items");
        return rawItems.stream()
                .map(rawItem -> mapToItem(rawItem, order.getInteger("id")))
                .collect(Collectors.toList());
    }

    private Item mapToItem(Document rawItem, Integer orderId) {
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
}
