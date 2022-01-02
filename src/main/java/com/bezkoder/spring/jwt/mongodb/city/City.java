package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "city")
public class City {
    private String name;

    @ManyToOne
    @JoinColumn(name= RelationshipConstants.STATE_ID)
    private State state;

}
