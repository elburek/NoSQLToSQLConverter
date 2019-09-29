package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mgr.models.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class GraphicCard implements Item {

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
    private Integer memory;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        setOrderId(id);
    }
}
