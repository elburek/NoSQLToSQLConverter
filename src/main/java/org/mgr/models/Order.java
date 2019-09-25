package org.mgr.models;

import lombok.Data;
import org.mgr.models.entities.Client;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private long id;
    private Client client;
    private String deliveryAddress;
    private Date date;
    private List<Item> items;

}
