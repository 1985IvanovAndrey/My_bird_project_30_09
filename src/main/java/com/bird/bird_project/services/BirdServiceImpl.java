package com.bird.bird_project.services;

import com.bird.bird_project.dao.BirdEntity;
import com.bird.bird_project.dao.repository.BirdRepository;
import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.dto.BirdListDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
public class BirdServiceImpl implements BirdService {
    int priceForKg=0;

    @Autowired
    private BirdRepository birdRepository;

    @Override
    public BirdDto getOne(int weight) {
        BirdEntity birdEntity = birdRepository.findByWeight(weight);
        BirdDto birdDto = new BirdDto();
        birdDto.setTypeBird(birdEntity.getBirdType());
        birdDto.setPricePerUnit(birdEntity.getPricePerUnit());

        return birdDto;
    }

    @Override
    public List<BirdDto> getAllBirds() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        for (BirdEntity birdEntity : birdRepository.findAll()) {
            BirdDto birdDto = new BirdDto();
            birdDto.setTypeBird(birdEntity.getBirdType());
            birdDto.setPricePerUnit(birdEntity.getPricePerUnit());
            birdDto.setWeight(birdEntity.getWeight());

            birdDtoList.add(birdDto);
        }

        return birdDtoList;
    }

    @Override
    public BirdListDto birdListDto() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        for (BirdEntity birdEntity : birdRepository.findAll()) {
            BirdDto birdDto = new BirdDto();
            birdDto.setTypeBird(birdEntity.getBirdType());
            birdDto.setPricePerUnit(birdEntity.getPricePerUnit());
            birdDto.setWeight(birdEntity.getWeight());
            birdDtoList.add(birdDto);
        }
        return new BirdListDto(birdDtoList);
    }
@Override
    public void addBirdInDB(BirdDto birdDto,String health) {
        BirdEntity birdEntity = new BirdEntity();
        birdEntity.setBirdType(birdDto.getTypeBird());
        //int priceForKg = getPriceForKg()
        birdEntity.setPricePerUnit(birdDto.getWeight() * priceForKg);
        birdEntity.setWeight(birdDto.getWeight());
        birdEntity.setBirdHealth(health);
        log.info("bird add in DB{}", birdEntity);
        birdRepository.saveAndFlush(birdEntity);
    }
    @Override
    public int getPriceForKg(int price){
      return   priceForKg=price;
    }
}
