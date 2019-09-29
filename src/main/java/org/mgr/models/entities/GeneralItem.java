package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GeneralItem implements Item {

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

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        setOrderId(id);
    }
}
