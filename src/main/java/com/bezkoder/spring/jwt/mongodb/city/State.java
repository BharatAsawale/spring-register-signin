package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "state")
public class State {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String state;
}
