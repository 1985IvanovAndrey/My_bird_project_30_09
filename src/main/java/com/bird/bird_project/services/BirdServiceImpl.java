package com.bird.bird_project.services;

import com.bird.bird_project.dao.BirdEntity;
import com.bird.bird_project.dao.repository.BirdRepository;
import com.bird.bird_project.dto.BirdDto;
import com.bird.bird_project.dto.BirdListDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository birdRepository;

    @Override
    public BirdDto getBirdByTypeAndTotalWeight(String type, int weight) {
        BirdDto birdDto = null;
        BirdEntity bird = null;
        int price = 0;
        try {
            bird = birdRepository.findByBirdTypeAndTotalWeight(type, weight);
            log.info(bird);
            log.info(birdRepository.findByBirdTypeAndTotalWeight(type, weight));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  1. Создать  ДТО для ответа
        birdDto = new BirdDto();
        //  2. Создать конвертар цен от условия
        try {
            price = checkPriceByWeight(bird, weight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  3. Засетить Дто и отдать
        birdDto.setTotalPrice(price);
        birdDto.setTotalWeight(bird.getTotalWeight());
        birdDto.setTypeBird(bird.getBirdType());
        birdDto.setTotalSum(bird.getTotalWeight() * price);
        birdDto.setDiscount(bird.getPricePerUnit() - price);
        return birdDto;
    }

    @Override
    public List<BirdDto> getAllBirds() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        for (BirdEntity birdEntity : birdRepository.findAll()) {
            BirdDto birdDto = new BirdDto();
            birdDto.setTypeBird(birdEntity.getBirdType());
            birdDto.setTotalPrice(birdEntity.getPricePerUnit());
            birdDto.setTotalWeight(birdEntity.getTotalWeight());
            birdDtoList.add(birdDto);
        }
        return birdDtoList;
    }

    @Override
    public BirdListDto getAllbirdsToShop() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        for (BirdEntity birdEntity : birdRepository.findAll()) {
            int price = checkPriceByWeight(birdEntity, birdEntity.getTotalWeight());
            BirdDto birdDto = new BirdDto();
            birdDto.setTypeBird(birdEntity.getBirdType());
            birdDto.setTotalPrice(price);
            birdDto.setTotalWeight(birdEntity.getTotalWeight());
            birdDto.setTotalSum(birdEntity.getTotalWeight() * price);
            birdDto.setDiscount(birdEntity.getPricePerUnit() - price);
            birdDtoList.add(birdDto);
        }
        birdRepository.deleteAll();
        return new BirdListDto(birdDtoList);
    }

    @Override
    public void addBirdInDB(BirdDto birdDto) throws IOException{
        Bird bird = Bird.CHICKEN;
        for (Bird bird1 : Bird.values()) {
            if (bird1.toString().toLowerCase().equals(birdDto.getTypeBird())) {
                BirdEntity birdEntity = birdRepository.findByBirdType(birdDto.getTypeBird());
                if (birdEntity == null) {
                    BirdEntity birdEntity1 = new BirdEntity();
                    birdEntity1.setBirdType(birdDto.getTypeBird());
                    try {
                        birdEntity1.setTotalWeight(birdDto.getTotalWeight());
                        birdEntity1.setPricePerUnit(birdDto.getTotalPrice());
                        birdRepository.saveAndFlush(birdEntity1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    try {
                        birdEntity.setTotalWeight(birdEntity.getTotalWeight() + birdDto.getTotalWeight());
                        birdEntity.setPricePerUnit(birdDto.getTotalPrice());
                        birdRepository.saveAndFlush(birdEntity);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private int checkPriceByWeight(BirdEntity bird, int weight) {
        int price = 0;
        switch (bird.getBirdType()) {
            case "duck":
                price = bird.getPricePerUnit();
                if (weight >= 15 && weight < 25) {
                    price--;
                } else if (weight >= 25) {
                    price -= 2;
                }
                break;
            case "chicken":
                price = bird.getPricePerUnit();
                if (weight >= 20 && weight < 40) {
                    price--;
                } else if (weight >= 40) {
                    price -= 2;
                }
                break;
            case "quail":
                price = bird.getPricePerUnit();
                if (weight >= 18 && weight < 30) {
                    price--;
                } else if (weight >= 30) {
                    price -= 2;
                }
                break;
            case "turkey":
                price = bird.getPricePerUnit();
                if (weight >= 5 && weight < 20) {
                    price--;
                } else if (weight >= 20) {
                    price -= 2;
                }
                break;
        }
        return price;
    }

    @Override
    public BirdDto getBirdByTypeAndTotalWeightNew(String type, int weight) {
        BirdDto birdDto = new BirdDto();
        BirdEntity birdEntity = null;
        int price = 0;
        try {
            birdEntity = birdRepository.findByBirdType(type);
            log.info(birdEntity);
            if (birdEntity.getTotalWeight() - weight >= 0) {
                birdDto.setTypeBird(type);
                birdDto.setTotalWeight(weight);
                price = checkPriceByWeight(birdEntity, weight);
                birdDto.setTotalSum(weight * price);
                birdDto.setDiscount(birdEntity.getPricePerUnit() - price);
                birdDto.setTotalPrice(price);
                birdEntity.setTotalWeight(birdEntity.getTotalWeight() - weight);
            }
            birdRepository.saveAndFlush(birdEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return birdDto;
    }

    @Override
    public List<Bird> allTypeBird() {
        List<Bird> birdList = new ArrayList<>();
        Bird bird = Bird.CHICKEN;
        for (Bird bird1 : Bird.values()) {
            String type = bird1.toString().toLowerCase();
            birdList.add(bird1);
        }
        return birdList;
    }
}






