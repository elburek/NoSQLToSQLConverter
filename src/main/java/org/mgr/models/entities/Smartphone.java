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
@Table(name = "smartphones")
public class Smartphone implements Item {

    @Id
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String camera;
    @Column
    private String memory;
}
