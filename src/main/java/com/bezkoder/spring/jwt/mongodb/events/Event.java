package com.bezkoder.spring.jwt.mongodb.events;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "event")
public class Event {
    private int id;
    private String organizer;
    private String details;
    private int amount;
    private Date date;
    private String contact;
    private String email;
    private String url;
}
