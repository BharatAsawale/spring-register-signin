package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import com.bezkoder.spring.jwt.mongodb.Forts.Eng.FortDetails;
import com.bezkoder.spring.jwt.mongodb.Forts.Eng.FortDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/fortdetails")
public class FortMarDetailsController {
    @Autowired
    private final FortMarRepo fortMarRepo;
    @Autowired
    private final FortMarDetailsRepo fortMarDetailsRepo;
    private final FortDetailsRepo fortDetailsRepo;

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
