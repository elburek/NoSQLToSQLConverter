package models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column
    private String objectId;
    @Column
    private String name;
    @Column
    private String price;
    @Column
    private Integer quantity;

}
