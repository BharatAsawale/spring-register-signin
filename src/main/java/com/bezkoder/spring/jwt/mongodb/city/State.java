package com.bezkoder.spring.jwt.mongodb.city;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "state")
public class State {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String img;
}
