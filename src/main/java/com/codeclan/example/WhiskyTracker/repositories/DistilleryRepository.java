package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
//    Get all the distilleries for a particular region
    List<Distillery> findAllDistilleriesByRegion(String region);

    //Find distillery by ID

    Distillery findDistilleryById(Long id);

}
