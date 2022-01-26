package com.bezkoder.spring.jwt.mongodb.events;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventRepo eventRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        Event event1=eventRepo.save(event);
        return new ResponseEntity<>(event1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> allEvents(){
        List<Event> eventList=eventRepo.findAll();
        return new ResponseEntity<>(eventList,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public  ResponseEntity<?> findEventById(@PathVariable int id){
        Event event=eventRepo.findById(id);
        if(event==null)
            return ResponseEntity.badRequest().body("no data found..");
        return new ResponseEntity<>(event,HttpStatus.OK);
    }

}
