package com.bezkoder.spring.jwt.mongodb.city.Mar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "citymar")
public class CityMar {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String city;
    @DBRef
    @Column(nullable = false)
    private StateMar state;
}
