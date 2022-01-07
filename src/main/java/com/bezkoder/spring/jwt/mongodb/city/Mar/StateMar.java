package com.bezkoder.spring.jwt.mongodb.city.Mar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "statemar")
public class StateMar {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String img;
}

