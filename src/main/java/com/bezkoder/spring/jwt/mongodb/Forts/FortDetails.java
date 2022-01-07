package com.bezkoder.spring.jwt.mongodb.Forts;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fortDetails")
public class FortDetails {
    @Id
    private int id;
    @Column(nullable = false)
    private int fortId;
    @Column(nullable = false)
    private String fortName;
    @Column(nullable = false)
    private String locationDetails;
    @Column(nullable = false)
    private String history;
    @Column(nullable = false)
    private String features;
    @Column(nullable = false)
    private String controlledBy;
    @Column(nullable = false)
    private String transportFacility;
    @Column(nullable = false)
    private String stayFacility;
    @Column(nullable = false)
    private String nearByPlaces;
    @Column(nullable = false)
    private String typeOfFort;
    @Column(nullable = false)
    private String height;
}
