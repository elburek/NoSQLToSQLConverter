import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.entities.Item;
import org.bson.Document;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        MongoController mongoController = new MongoController("localhost", 27017, "MGR");
        List<Document> items = mongoController.extractDocumentsFromCollection("items");
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Item.class, new ItemDeserializer())
                .create();
        Item item = gson.fromJson(items.get(0).append("dupa", "dupa2").toJson(), Item.class);
        System.out.println("asda");









//        Item item2;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            item2 = objectMapper.readValue(items.get(0).append("dupa", "dupa2").toJson(), Item.class);
//
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            String jdbcurl = "jdbc:mysql://localhost:3306/mgr?serverTimezone=UTC";
//            Properties properties = new Properties();
//            properties.put("user", "root");
//            properties.put("password", "12345");
//            Connection connection = DriverManager.getConnection(jdbcurl, "root", "12345");
//            System.out.println("a");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        //hibernate
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Item.class)
//                .buildSessionFactory();
//
//        Session session = sessionFactory.getCurrentSession();
//        try {
//            Item item1 = new Item(null, "elo", "33", 2);
//            session.beginTransaction();
//            session.save(item1);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//
//        } finally {
//            sessionFactory.close();
//        }




        //Mysql port: 3306, pass: 12345
    }


}
