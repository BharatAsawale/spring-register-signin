package com.bezkoder.spring.jwt.mongodb.Forts;

import com.bezkoder.spring.jwt.mongodb.city.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
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
