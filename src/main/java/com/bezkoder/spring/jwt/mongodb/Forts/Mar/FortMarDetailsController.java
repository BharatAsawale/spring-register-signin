package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import com.bezkoder.spring.jwt.mongodb.Forts.Eng.FortDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/fortdetails")
public class FortMarDetailsController {
    @Autowired
    private final FortMarRepo fortMarRepo;
    @Autowired
    private final FortMarDetailsRepo fortMarDetailsRepo;

    @PostMapping("/add/{fid}")
    public ResponseEntity<?> add(@RequestBody FortMarDetails fortMarDetails,@PathVariable int fid){
        FortMar fortMar=fortMarRepo.findById(fid);
        if (fortMar==null)
            return ResponseEntity.badRequest().body("Fort not found");
        fortMarDetails.setFortId(fid);
        fortMarDetails.setFortName(fortMar.getFortName());
        FortMarDetails fortMarDetails1=fortMarDetailsRepo.save(fortMarDetails);
        return new ResponseEntity<>(fortMarDetails1,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        FortMarDetails fortMarDetails=fortMarDetailsRepo.findByFortId(id);
        if (fortMarDetails==null)
            return ResponseEntity.badRequest().body("Fort Details not found");
        return new ResponseEntity<>(fortMarDetails,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FortMarDetails>> getAll(){
        return new ResponseEntity<>(fortMarDetailsRepo.findAll(),HttpStatus.OK);
    }
}
