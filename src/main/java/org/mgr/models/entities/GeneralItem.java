package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GeneralItem {

    @Id
    @Column
    private String id;
    @Column
    private String orderId;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;
    @Column
    private Category category;

    public enum Category {
        CAR,
        SMARTPHONE,

    }
}
