package com.bezkoder.spring.jwt.mongodb.Forts;

import com.bezkoder.spring.jwt.mongodb.city.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fort")
public class Fort {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String fortName;
    @Column(nullable = false)
    private int cityId;
    @JsonIgnore
    @DBRef
    private City city;

}
