package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column
    private Integer id;
    @Column
    private Integer clientId;
    @Column
    private String deliveryAddress;
    @Column
    private Integer itemId;
    @Column
    private Timestamp date;
}
