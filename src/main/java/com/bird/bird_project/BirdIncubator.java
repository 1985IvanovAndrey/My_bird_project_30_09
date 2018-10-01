package com.bird.bird_project;

import com.bird.bird_project.dao.BirdEntity;
import com.bird.bird_project.dao.repository.BirdRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class BirdIncubator {

    @Autowired
    private BirdRepository birdRepository;

    @PostConstruct
    public void incubator() {
        BirdEntity duck = new BirdEntity("duck", 8, 40);
        birdRepository.save(duck);
        BirdEntity chicken = new BirdEntity("chicken", 4, 80);
        birdRepository.save(chicken);
        BirdEntity quail = new BirdEntity("quail", 7, 60);
        birdRepository.save(quail);
        BirdEntity turkey = new BirdEntity("turkey", 5, 60);
        birdRepository.save(turkey);

    }
}
