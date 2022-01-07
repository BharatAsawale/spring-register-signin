package com.bezkoder.spring.jwt.mongodb.city.En;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/state")
public class StateController {
    private final StateRepo stateRepo;

    @PostMapping(value = "/add")
    public ResponseEntity<State> AddState(@RequestBody State state){
        State state1=new State();
        state1=stateRepo.save(state);
        return new ResponseEntity<>(state1, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<State>> allStates(){
        return new ResponseEntity<>(stateRepo.findAll(),HttpStatus.OK);
    }

}
