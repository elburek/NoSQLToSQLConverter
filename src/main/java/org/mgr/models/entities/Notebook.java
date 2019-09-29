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
@Table(name = "notebooks")
public class Notebook implements Item {

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
    private Integer diagonal;
    @Column
    private Integer graphicCardId;
    @Transient
    private GraphicCard graphicCard;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        setOrderId(id);
    }
}
