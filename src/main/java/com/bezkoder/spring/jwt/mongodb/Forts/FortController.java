package com.bezkoder.spring.jwt.mongodb.Forts;

import com.bezkoder.spring.jwt.mongodb.city.City;
import com.bezkoder.spring.jwt.mongodb.city.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FortController {
    private final FortRepo fortRepo;
    private final CityRepo cityRepo;
    private final FortDetailsRepo fortDetailsRepo;

    @PostMapping("/fort/add")
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

    @GetMapping("/fort/all")
    public ResponseEntity<List<Fort>> all(){
        List<Fort> list=fortRepo.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/fort/{id}")
    public ResponseEntity<?> findFort(@PathVariable int id){
        Fort fort=new Fort();
        fort = fortRepo.findById(id);
        if (fort==null)
            return ResponseEntity.badRequest().body("Fort not found with id");
        return new ResponseEntity<>(fortRepo.findById(id),HttpStatus.OK);
    }

    @GetMapping("/fort/city/{id}")
    public ResponseEntity<?> findFortByCity(@PathVariable int id){
        City city=cityRepo.findById(id);
        if(city==null)
            return ResponseEntity.badRequest().body("no data found for given city");
        List<Fort> fortList=new ArrayList<>();
        fortList=fortRepo.findByCity(city);
        return new ResponseEntity<>(fortList,HttpStatus.OK);
    }

    @PostMapping("/fortdetails/add/{fid}")
    public ResponseEntity<?> addFortDetails(@RequestBody FortDetails fortDetails, @PathVariable int fid){
        Fort fort=new Fort();
        fort = fortRepo.findById(fid);
        if (fort==null)
            return ResponseEntity.badRequest().body("Fort not found with given id");
        fortDetails.setFort(fort);
        FortDetails fortDetails1=new FortDetails();
        fortDetails1=fortDetailsRepo.save(fortDetails);
        return new ResponseEntity<>(fortDetails1,HttpStatus.OK);
    }

    @GetMapping("/fortdetails/all")
    public ResponseEntity<?> fortDetailsAll(){
        List<FortDetails> list=new ArrayList<>();
        list=fortDetailsRepo.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/fortdetails/{id}")
    public ResponseEntity<?> fortDetailsById(@PathVariable int id){
        Fort fort=new Fort();
        fort=fortRepo.findById(id);
        FortDetails fortDetails=new FortDetails();
        fortDetails=fortDetailsRepo.findFortDetailsByFort(fort);
        if(fortDetails==null)
            return ResponseEntity.badRequest().body("No Detials found with given id");
        return new ResponseEntity<>(fortDetails,HttpStatus.OK);
    }

}
