package com.bezkoder.spring.jwt.mongodb.city.Mar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mar/city")
public class CityMarController {
    private final StateMarRepo stateMarRepo;
    private final CityMarRepo cityMarRepo;

    @PostMapping("/add/{sid}")
    public ResponseEntity<?> addCity(@RequestBody CityMar cityMar,@PathVariable int sid){
        StateMar stateMar=stateMarRepo.findById(sid);
        if (stateMar==null)
            return ResponseEntity.badRequest().body("State not found..");
        cityMar.setState(stateMar);
        CityMar cityMar1=cityMarRepo.save(cityMar);
        return new ResponseEntity<>(cityMar1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(cityMarRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityMar> findById(@PathVariable int id){ return new ResponseEntity<>(cityMarRepo.findById(id),HttpStatus.OK); }

    @GetMapping("/state/{id}")
    public ResponseEntity<?> findCitiesByState(@PathVariable int id){
        StateMar stateMar=stateMarRepo.findById(id);
        if (stateMar==null)
            return ResponseEntity.badRequest().body("State not found with given id");
        List<CityMar> cityMarList = cityMarRepo.findAllByState(stateMar);
        return new ResponseEntity<>(cityMarList,HttpStatus.OK);
    }

    @GetMapping("/addallcity")
    public String addAllCity(){
        String[] dis={"अजमेर","अलवार","बांसवाडा","बरान","बारमेर","भरतपुर","भिलवाडा","बिकानेर","बुंदी","चित्तोडगढ","चुरू","दौसा",
                "धोलपुर","डुंगरपुर","हनुमानगढ","जयपुर","जेसलमेर","जालोर","झालावाड","झुनझुनुन",
                "जोधपुर","करौली","कोटा","नागौर","पाली","प्रतापगढ",
                "रजसामंड","सवाई माधोपूर","सिकर","सिरोही","गंगानगर","टोंक","उदयपूर"};
        int count=301;
        StateMar state=stateMarRepo.findById(3);
        if(state==null)
            return "State Not Found";
        for(String d:dis){
            CityMar city=new CityMar();
            city.setId(count++);
            city.setCity(d);
            city.setState(state);
            cityMarRepo.save(city);
        }
        return "done";
    }
}
