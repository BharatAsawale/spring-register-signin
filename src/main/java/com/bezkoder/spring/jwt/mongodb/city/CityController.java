package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class CityController {
    private final CityRepo cityRepo;
    private final StateRepo stateRepo;

    @PostMapping(value = "/addstate")
    public ResponseEntity<State> AddState(@RequestBody State state){
        State state1=new State();
        state1=stateRepo.save(state);
        return new ResponseEntity<>(state1, HttpStatus.OK);
    }
    @PostMapping(value = "/addcity")
    public ResponseEntity<City> AddCity(@RequestBody City city){
        City city1=new City();
        city1=cityRepo.save(city);
        return new ResponseEntity<>(city1,HttpStatus.OK);
    }
    @GetMapping("/city/all")
    public List<City> allCity(){
        List list=cityRepo.findAll();
        return list;
    }
    @GetMapping("/city/{state}")
    public List<?> findByState(@PathVariable String state){
        List<City> city=cityRepo.findCitiesByStateName(state);
        List list=new ArrayList<>();
        list.addAll(city.stream().map(city1 -> city1.getName()).collect(Collectors.toList()));
        return list;
    }

}
