package com.bird.bird_project.controller;

import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.dto.BirdListDto;
import com.bird.bird_project.services.BirdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@Log4j2
public class BirdRestController {
    @Autowired
    private BirdService birdService;

    @GetMapping("getall")
    public BirdListDto getAllBird() {
        try {
            BirdListDto birdDtos = birdService.birdListDto();
            log.info(" return all bird - ok {}", birdDtos);
            return birdDtos;
        } catch (Exception e) {
            throw new IllegalArgumentException("exception can't get all birds");
        }
    }
}


