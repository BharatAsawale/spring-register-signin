package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import com.bezkoder.spring.jwt.mongodb.city.Mar.CityMar;
import com.bezkoder.spring.jwt.mongodb.city.Mar.CityMarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/fort")
public class FortMarController {
    @Autowired
    private final CityMarRepo cityMarRepo;
    @Autowired
    private final FortMarRepo fortMarRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody FortMar fortMar){
        FortMar fortMar1=new FortMar();
        int cid=fortMar.getCityId();
        CityMar city=cityMarRepo.findById(cid);
        if(city==null)
            return ResponseEntity.badRequest().body("City Not Found..!");
        fortMar.setCity(city);
        fortMar1=fortMarRepo.save(fortMar);
        return new ResponseEntity<>(fortMar1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FortMar>> all(){
        List<FortMar> list=fortMarRepo.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findFort(@PathVariable int id){
        FortMar fortMar = fortMarRepo.findById(id);
        if (fortMar==null)
            return ResponseEntity.badRequest().body("Fort Not found...");
        return new ResponseEntity<>(fortMar,HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<?> findFortByCity(@PathVariable int id){
        CityMar cityMar=cityMarRepo.findById(id);
        if (cityMar==null)
            return ResponseEntity.badRequest().body("City not found..");
        List<FortMar> fortMarList=fortMarRepo.findByCity(cityMar);
        return new ResponseEntity<>(fortMarList,HttpStatus.OK);
    }
}
