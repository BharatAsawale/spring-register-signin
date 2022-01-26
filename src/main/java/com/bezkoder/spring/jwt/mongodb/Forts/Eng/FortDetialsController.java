package com.bezkoder.spring.jwt.mongodb.Forts.Eng;

import com.bezkoder.spring.jwt.mongodb.Forts.Mar.FortMarDetails;
import com.bezkoder.spring.jwt.mongodb.Forts.Mar.FortMarDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fortdetails")
public class FortDetialsController {
    private final FortMarDetailsRepo fortMarDetailsRepo;
    private final FortDetailsRepo fortDetailsRepo;
    private final FortRepo fortRepo;

    @PostMapping("/add/{fid}")
    public ResponseEntity<?> add(@RequestBody FortDetails fortDetails, @PathVariable int fid){
        Fort fort=fortRepo.findById(fid);
        if (fort==null)
            return ResponseEntity.badRequest().body("Fort not found with id");
        fortDetails.setFortId(fid);
        fortDetails.setFortName(fort.getFortName());
        FortDetails fortDetails1=fortDetailsRepo.save(fortDetails);
        return new ResponseEntity<>(fortDetails1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        FortDetails fortDetails=fortDetailsRepo.findByFortId(id);
        if (fortDetails==null)
            return ResponseEntity.badRequest().body("Fort Details Not Found");
        return new ResponseEntity<>(fortDetails,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FortDetails>> getAll(){
        return new ResponseEntity<>(fortDetailsRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/like/{fid}/{userId}")
    public ResponseEntity<?> addLikes(@PathVariable int fid,@PathVariable String userId){
        FortDetails fd=fortDetailsRepo.findById(fid);
        FortMarDetails fmd=fortMarDetailsRepo.findById(fid);
        if(fd==null || fmd==null)
            return ResponseEntity.badRequest().body("fort details not found");
        Set<String> set=fd.getLikes();
        Set<String> setMar=fmd.getLikes();
        if(set==null || setMar==null){
            Set<String> set1=new HashSet<>();
            set1.add(userId);
            fd.setLikes(set1);
            fmd.setLikes(set1);
        }
        else
            set.add(userId);
        fortDetailsRepo.save(fd);
        fortMarDetailsRepo.save(fmd);
        return new ResponseEntity<>(fmd,HttpStatus.OK);
    }
}