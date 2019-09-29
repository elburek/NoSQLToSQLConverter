package org.mgr.models.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mgr.models.Item;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car implements Item {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer orderId;
    @Column
    private Integer price;
    @Column
    private Integer quantity;
    @Column
    private Integer horsePower;
    @Column
    private int doors;
    @Column
    @Enumerated(EnumType.STRING)
    Transmission transmission;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        setOrderId(id);
    }

    private enum Transmission {
        AUTOMATIC,
        MANUAL,
    }
}
