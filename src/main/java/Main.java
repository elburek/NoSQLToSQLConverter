import com.google.gson.Gson;
import models.Item;
import org.bson.Document;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        MongoController mongoController = new MongoController("localhost", 27017, "MGR");
        List<Document> items = mongoController.extractDocumentsFromCollection("items");
        Gson gson = new Gson();
        Item item = gson.fromJson(items.get(0).append("dupa", "dupa2").toJson(), Item.class);
        System.out.println("2");

    }


}
