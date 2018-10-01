package com.bird.bird_project.dao.repository;

import com.bird.bird_project.dao.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Long> {

    BirdEntity findByTotalWeight(int weight);

    BirdEntity findByBirdTypeAndTotalWeight(String type, int totalWeight);

    BirdEntity findByBirdTypeAndPricePerUnit(String type, int pricePerUnit);

    BirdEntity findByBirdType(String type);

}
