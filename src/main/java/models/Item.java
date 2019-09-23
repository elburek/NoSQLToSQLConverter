package models;

import com.google.gson.annotations.SerializedName;
import org.bson.types.ObjectId;

public class Item {

    @SerializedName("_id")
    ObjectId objectId;
    String name;
    @SerializedName(value="price", alternate={"value", "cost"})
    String price;
    Integer quantity;

}
