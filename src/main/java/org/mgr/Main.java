package org.mgr;

public class Main {

    public static void main(String[] args) {
        NoSQLToSQLConverter noSQLToSQLConverter = new NoSQLToSQLConverter();
        noSQLToSQLConverter.convert();


//        GeneralItem item2;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            item2 = objectMapper.readValue(generalItems.get(0).append("dupa", "dupa2").toJson(), GeneralItem.class);
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
//            org.mgr.Config properties = new org.mgr.Config();
//            properties.put("user", "root");
//            properties.put("password", "12345");
//            Connection connection = DriverManager.getConnection(jdbcurl, "root", "12345");
//            System.out.println("a");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}
