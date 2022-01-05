package com.bezkoder.spring.jwt.mongodb.Forts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fortDetails")
public class FortDetails {
    @Id
    private int id;
    @DBRef
    @Column(nullable = false)
    private Fort fort;
    @Column(nullable = false)
    private String locationDetails;
    @Column(nullable = false)
    private String history;
    @Column(nullable = false)
    private String features;
    @Column(nullable = false)
    private String[] controlledBy;
    @Column(nullable = false)
    private String[] transportFacility;
    @Column(nullable = false)
    private String stayFacility;
    @Column(nullable = false)
    private String[] nearByPlaces;
    @Column(nullable = false)
    private String typeOfFort;
    @Column(nullable = false)
    private String height;

}
