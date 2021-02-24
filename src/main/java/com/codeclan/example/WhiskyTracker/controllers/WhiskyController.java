package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/year/{year}")
    public ResponseEntity<List<Whisky>> getWhiskiesByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findAllWhiskiesByYear(year), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/id/{id}")
    public ResponseEntity getWhiskyByID(@PathVariable Long id){
        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/distillery/{id}/{age}")
    public ResponseEntity<List<Whisky>> getWhiskiesByDistAndAge(
            @PathVariable Long id,
            @PathVariable int age){
        Distillery distillery = distilleryRepository.findDistilleryById(id);
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryAndAge(distillery,age), HttpStatus.OK);

    }

}
