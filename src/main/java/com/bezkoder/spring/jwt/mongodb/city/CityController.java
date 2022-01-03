package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CityController {
    private final CityRepo cityRepo;
    private final StateRepo stateRepo;

    @PostMapping(value = "/state/add")
    public ResponseEntity<State> AddState(@RequestBody State state){
        State state1=new State();
        state1=stateRepo.save(state);
        return new ResponseEntity<>(state1, HttpStatus.OK);
    }

    @GetMapping(value = "states/all")
    public ResponseEntity<List<State>> allStates(){
        return new ResponseEntity<>(stateRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping(value = "cities/all")
    public ResponseEntity<List<City>> allCities(){
        return new ResponseEntity<>(cityRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/cities/{id}")
    public ResponseEntity<?> findCitiesById(@PathVariable int id){
        State state=stateRepo.findById(id);
        List<City> cities=cityRepo.findAllCitiesByState(state);
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }
    @GetMapping("/statecity/all")
    public ResponseEntity<StateCities> allCity(){
        StateCities stateCities=new StateCities();
        List<State> list=stateRepo.findAll();
        List<City> list1=cityRepo.findAll();
        stateCities.setStates(list);
        stateCities.setCities(list1);
        return new ResponseEntity<>(stateCities,HttpStatus.OK);
    }

    @PostMapping(value = "/city/add")
    public ResponseEntity<?> AddCity(@RequestBody AddCity addCity){
        int sid=addCity.getStateId();
        State state=stateRepo.findById(sid);
        if(state==null)
            return ResponseEntity.badRequest().body("State Not Found");
        City city=new City();
        city.setId(addCity.getId());
        city.setState(state);
        city.setCity(addCity.getCity());
        City city1=new City();
        city1=cityRepo.save(city);
        return new ResponseEntity<>(city1,HttpStatus.OK);
    }


//    @GetMapping("/city/addallcity")
//    public String addAllCity(){
//        String[] dis={"Bagalkot","Ballari (Bellary)","Belagavi (Belgaum)","Bengaluru (Bangalore) Rural","Bengaluru (Bangalore) Urban","Bidar","Chamarajanagar","Chikballapur","Chikkamagaluru (Chikmagalur)",
//                "Chitradurga","Dakshina Kannada","Davangere","Dharwad","Gadag","Hassan","Haveri","Kalaburagi (Gulbarga)","Kodagu","Kolar","Koppal","Mandya",
//                "Mysuru (Mysore)","Raichur","Ramanagara","Shivamogga (Shimoga)","Tumakuru (Tumkur)","Udupi","Uttara Kannada (Karwar)","Vijayapura (Bijapur)","Yadgir"};
//        int count=201;
//        State state=stateRepo.findById(2);
//        if(state==null)
//            return "State Not Found";
//        for(String d:dis){
//            City city=new City();
//            city.setId(count++);
//            city.setCity(d);
//            city.setState(state);
//            cityRepo.save(city);
//        }
//        return "done";
//    }

}