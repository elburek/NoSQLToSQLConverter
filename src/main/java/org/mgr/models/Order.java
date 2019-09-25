package org.mgr.models;

import lombok.Data;
import org.mgr.models.entities.Client;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Client client;
    private Address deliveryAddress;
    private List<Item> items;
    private Date date;
}
