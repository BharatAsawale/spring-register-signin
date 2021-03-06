package com.bezkoder.spring.jwt.mongodb.Forts.Eng;

import com.bezkoder.spring.jwt.mongodb.city.En.City;
import com.bezkoder.spring.jwt.mongodb.city.En.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/fort")
public class FortController {
    @Autowired
    private final FortRepo fortRepo;
    @Autowired
    private final CityRepo cityRepo;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Fort fort){
        Fort fort1=new Fort();
        int cid=fort.getCityId();
        City city=new City();
        city=cityRepo.findById(cid);
        if (city==null)
            return ResponseEntity.badRequest().body("City Not Found..");
        fort.setCity(city);
        fort1=fortRepo.save(fort);
        return new ResponseEntity<>(fort1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fort>> all(){
        List<Fort> list=fortRepo.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findFort(@PathVariable int id){
        Fort fort=new Fort();
        fort = fortRepo.findById(id);
        if (fort==null)
            return ResponseEntity.badRequest().body("Fort not found with id");
        return new ResponseEntity<>(fortRepo.findById(id),HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<?> findFortByCity(@PathVariable int id){
        City city=cityRepo.findById(id);
        if(city==null)
            return ResponseEntity.badRequest().body("no data found for given city");
        List<Fort> fortList=new ArrayList<>();
        fortList=fortRepo.findByCity(city);
        return new ResponseEntity<>(fortList,HttpStatus.OK);
    }

}
