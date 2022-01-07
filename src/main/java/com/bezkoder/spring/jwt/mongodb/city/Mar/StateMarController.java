package com.bezkoder.spring.jwt.mongodb.city.Mar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/state/")
public class StateMarController {
    private final StateMarRepo stateMarRepo;

    @PostMapping(value = "/add")
    public ResponseEntity<StateMar> AddState(@RequestBody StateMar stateMar){
        StateMar state=new StateMar();
        state=stateMarRepo.save(stateMar);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<StateMar>> allStates(){
        return new ResponseEntity<>(stateMarRepo.findAll(),HttpStatus.OK);
    }

}
