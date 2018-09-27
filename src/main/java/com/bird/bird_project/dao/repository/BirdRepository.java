package com.bird.bird_project.dao.repository;

import com.bird.bird_project.dao.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Long>{

    BirdEntity findByWeight(int weight);
}
