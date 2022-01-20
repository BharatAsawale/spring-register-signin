package com.bezkoder.spring.jwt.mongodb.city.En;

import com.bezkoder.spring.jwt.mongodb.payload.response.StateCitiesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/city")
public class CityController {
    private final CityRepo cityRepo;
    private final StateRepo stateRepo;

    @PostMapping("/add/{sid}")
    public ResponseEntity<?> AddCity(@RequestBody City city, @PathVariable int sid){
        State state=stateRepo.findById(sid);
        if(state==null)
            return ResponseEntity.badRequest().body("State Not Found");
        city.setState(state);
        City city1=new City();
        city1=cityRepo.save(city);
        return new ResponseEntity<>(city1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<City>> allCities(){
        return new ResponseEntity<>(cityRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable int id) { return new ResponseEntity<>(cityRepo.findById(id),HttpStatus.OK); }

    @GetMapping("/state/{sid}")
    public ResponseEntity<?> findCitiesById(@PathVariable int sid){
        State state=stateRepo.findById(sid);
        List<City> cities=cityRepo.findAllCitiesByState(state);
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }

    @GetMapping("/statecity/all")
    public ResponseEntity<StateCitiesResponse> allCity(){
        StateCitiesResponse stateCities=new StateCitiesResponse();
        List<State> list=stateRepo.findAll();
        List<City> list1=cityRepo.findAll();
        stateCities.setStates(list);
        stateCities.setCities(list1);
        return new ResponseEntity<>(stateCities,HttpStatus.OK);
    }

    @GetMapping("/city/addallcity")
    public String addAllCity(){
        String[] dis={"Ajmer","Alwar","Banswara","Baran","Barmer","Bharatpur","Bhilwara","Bikaner","Bundi","Chittorgarh","Churu",
                        "Dausa","Dholpur","Dungarpur","Hanumangarh","Jaipur","Jaisalmer","Jalore","Jhalawar","Jhunjhunu","Jodhpur",
                        "Karauli","Kota","Nagaur","Pali","Pratapgarh","Rajsamand","Sawai Madhopur","Sikar","Sirohi","Sri Ganganagar",
                        "Tonk","Udaipur"};
        int count=301;
        State state=stateRepo.findById(3);
        if(state==null)
            return "State Not Found";
        for(String d:dis){
            City city=new City();
            city.setId(count++);
            city.setCity(d);
            city.setState(state);
            cityRepo.save(city);
        }
        return "done";
    }

}