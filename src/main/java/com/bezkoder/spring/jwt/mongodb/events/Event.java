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
    private String amount;
    private Date date;
    private String url;
}
