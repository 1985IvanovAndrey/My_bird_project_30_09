package com.bird.bird_project.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class BirdEntity {
    @Id
    @GeneratedValue
    private long Id;
    @Column
    private String birdType;
    @Column
    private int pricePerUnit;
    @Column
    private int totalWeight;

    public BirdEntity(String birdType, int pricePerUnit, int totalWeight) {
        this.birdType = birdType;
        this.pricePerUnit = pricePerUnit;
        this.totalWeight = totalWeight;
    }

    public BirdEntity() {
    }
}
