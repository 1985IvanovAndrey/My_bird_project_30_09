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
    private String birdHealth;
    @Column
    private int weight;


}
