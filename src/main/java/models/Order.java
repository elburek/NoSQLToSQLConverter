package models;

import lombok.Data;
import models.entities.Item;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Client client;
    private Address deliveryAddress;
    private List<Item> items;
    private Date date;
}
