package com.bird.bird_project.services;

import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.dto.BirdListDto;

import java.util.List;

public interface BirdService {

    BirdDto getOne(int name);

    List<BirdDto> getAllBirds();

    BirdListDto birdListDto();

    void addBirdInDB(BirdDto birdDto,String health);

    int getPriceForKg(int price);
}
