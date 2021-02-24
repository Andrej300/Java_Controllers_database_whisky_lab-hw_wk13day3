package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
//    Get all the whiskies for a particular year
    List<Whisky> findAllWhiskiesByYear(int year);

//    Get all the whisky from a particular distillery that is a specific age
    List<Whisky> findWhiskyByDistilleryAndAge(Distillery distillery, int age);
}


