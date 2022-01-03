package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "city")
public class City {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String city;
    @DBRef
    @Column(nullable = false)
    private State state;
}
