package com.bezkoder.spring.jwt.mongodb.Forts.Eng;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fortdetails")
public class FortDetialsController {
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

    @GetMapping("/like/{fid}/{userName}")
    public ResponseEntity<?> addLikes(@PathVariable int fid,@PathVariable String userName){
        FortDetails fd=fortDetailsRepo.findById(fid);
        if(fd==null)
            return ResponseEntity.badRequest().body("Invalid Request");
        List<String> list=fd.getLikes();
        if(list==null){
            List<String> list1=new ArrayList<>();
            list1.add(userName);
            fd.setLikes(list1);
        }
        else
            list.add(userName);
        fortDetailsRepo.save(fd);
        return new ResponseEntity<>(fd,HttpStatus.OK);
    }
}