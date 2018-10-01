package com.bird.bird_project.services;

import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.dto.BirdListDto;

import java.io.IOException;
import java.util.List;

public interface BirdService {


    BirdDto getBirdByTypeAndTotalWeight(String type, int weight);

    List<BirdDto> getAllBirds();

    BirdListDto getAllbirdsToShop();

    void addBirdInDB(BirdDto birdDto) throws IOException;

    BirdDto getBirdByTypeAndTotalWeightNew(String type, int weight);

    List<Bird> allTypeBird();
}
