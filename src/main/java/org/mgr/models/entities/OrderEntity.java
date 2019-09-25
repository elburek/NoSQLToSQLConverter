package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column
    private long id;
    @Column
    private long clientId;
    @Column
    private String deliveryAddress;
    @Column
    private long itemId;
    @Column
    private Date date;
}
