package org.mgr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "smartphones")
public class Smartphone extends GeneralItem {

    @Column
    private String frontCamera;
    @Column
    private String rearCamera;
    @Column
    private String model;
    @Column
    private String memory;
    @Column
    private String ram;
    @Column
    private Long batteryCapacity;
}