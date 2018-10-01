package com.bird.bird_project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class BirdDto {

    @JsonProperty
    private String typeBird;
    @JsonProperty
    private int totalWeight;
    @JsonProperty("price_per_unit")
    private int totalPrice;
    @JsonProperty
    private int totalSum;
    @JsonProperty
    private int discount;

    public BirdDto(String typeBird, int totalWeight, int totalPrice) {
        this.typeBird = typeBird;
        this.totalWeight = totalWeight;
        this.totalPrice = totalPrice;
    }

    public BirdDto() {
    }
}
