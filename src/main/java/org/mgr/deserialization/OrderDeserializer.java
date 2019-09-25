package org.mgr.deserialization;

import com.google.gson.*;
import org.mgr.models.entities.OrderEntity;

import java.lang.reflect.Type;

public class OrderDeserializer implements JsonDeserializer<OrderEntity> {

    private final Gson gson = new Gson();

    @Override
    public OrderEntity deserialize(final JsonElement jsonElement,
                                   final Type type,
                                   final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
//        String objectId = jsonObject.get("_id").getAsJsonObject().get("$oid").getAsString();
        OrderEntity orderEntity = gson.fromJson(jsonObject, OrderEntity.class);
//        orderEntity.setId(objectId);
        return orderEntity;
    }
}