package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import com.bezkoder.spring.jwt.mongodb.city.Mar.CityMar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fortmar")
public class FortMar{
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String fortName;
    @Column(nullable = false)
    private int cityId;
    @JsonIgnore
    @DBRef
    private CityMar city;

}
