package com.bezkoder.spring.jwt.mongodb.city.Mar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/city")
public class CityMarController {
    private final StateMarRepo stateMarRepo;
    private final CityMarRepo cityMarRepo;

    @PostMapping("/add/{sid}")
    public ResponseEntity<?> addCity(@RequestBody CityMar cityMar,@PathVariable int sid){
        StateMar stateMar=stateMarRepo.findById(sid);
        if (stateMar==null)
            return ResponseEntity.badRequest().body("State not found..");
        cityMar.setState(stateMar);
        CityMar cityMar1=cityMarRepo.save(cityMar);
        return new ResponseEntity<>(cityMar1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(cityMarRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityMar> findById(@PathVariable int id){ return new ResponseEntity<>(cityMarRepo.findById(id),HttpStatus.OK); }

    @GetMapping("/state/{id}")
    public ResponseEntity<?> findCitiesByState(@PathVariable int id){
        StateMar stateMar=stateMarRepo.findById(id);
        if (stateMar==null)
            return ResponseEntity.badRequest().body("State not found with given id");
        List<CityMar> cityMarList = cityMarRepo.findAllByState(stateMar);
        return new ResponseEntity<>(cityMarList,HttpStatus.OK);
    }
}
