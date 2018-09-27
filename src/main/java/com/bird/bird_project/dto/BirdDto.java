package com.bird.bird_project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class BirdDto {

    @JsonProperty("type_bird")
    private String typeBird;
    @JsonIgnore
//    @JsonProperty
//    private long amount;
    @JsonProperty("price_per_unit")
    private int pricePerUnit;
    @JsonProperty("bird_weight")
    private int weight;
//    @JsonIgnore
//    @JsonProperty
//    private String birdHealth;

}
