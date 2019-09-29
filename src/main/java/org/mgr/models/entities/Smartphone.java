package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "smartphones")
public class Smartphone implements Item {

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
    private String camera;
    @Column
    private String memory;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        setOrderId(id);
    }
}
