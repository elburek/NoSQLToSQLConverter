package org;

import com.google.gson.*;
import org.models.entities.Item;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {

    private final Gson gson = new Gson();

    @Override
    public Item deserialize(final JsonElement jsonElement,
                            final Type type,
                            final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String objectId = jsonObject.get("_id").getAsJsonObject().get("$oid").getAsString();
        Item item = gson.fromJson(jsonObject, Item.class);
        item.setObjectId(objectId);
        return item;
        }
    }