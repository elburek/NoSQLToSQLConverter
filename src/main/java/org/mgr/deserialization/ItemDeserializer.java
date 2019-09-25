package org.mgr.deserialization;

import com.google.gson.*;
import org.mgr.models.entities.GeneralItem;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<GeneralItem> {

    private final Gson gson = new Gson();

    @Override
    public GeneralItem deserialize(final JsonElement jsonElement,
                                   final Type type,
                                   final JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String objectId = jsonObject.get("_id").getAsJsonObject().get("$oid").getAsString();
        GeneralItem generalItem = gson.fromJson(jsonObject, GeneralItem.class);
        generalItem.setId(objectId);
        return generalItem;
        }
    }