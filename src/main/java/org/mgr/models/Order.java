package org.mgr.models;

import lombok.Data;
import org.mgr.models.entities.Client;

import java.sql.Timestamp;

@Data
public class Order {

    private Long id;
    private Client client;
    private String deliveryAddress;
    private Timestamp timestamp;
//    private List<Smartphone> items;

}
