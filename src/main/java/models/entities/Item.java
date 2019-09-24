package models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "items")
public class Item {

    @Id
    @Column
    private String objectId;
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
