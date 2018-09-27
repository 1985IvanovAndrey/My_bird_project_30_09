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
    public  void  incubator(){

//        for (int i=0; i<=2; i++){
//            BirdEntity birdEntity = new BirdEntity();
//            birdEntity.setBirdHealth((i+23)+"");
//            birdEntity.setBirdType("parrot");
//            birdEntity.setWeight(5+i);
//            birdEntity.setPricePerUnit(25+i);
//            birdRepository.save(birdEntity);
//
//        }
//
//        for (int i=0; i<=2; i++){
//            BirdEntity birdEntity = new BirdEntity();
//            birdEntity.setBirdHealth((i+30)+"");
//            birdEntity.setBirdType("eagl");
//            birdEntity.setWeight(10+i);
//            birdEntity.setPricePerUnit(40+i);
//            birdRepository.save(birdEntity);
//            }
//        for (int i=0; i<=2; i++){
//            BirdEntity birdEntity = new BirdEntity();
//            birdEntity.setBirdHealth((i+30)+"");
//            birdEntity.setBirdType("duck");
//            birdEntity.setWeight(10+i);
//            birdEntity.setPricePerUnit(40+i);
//            birdRepository.save(birdEntity);
//        }

    }
}
