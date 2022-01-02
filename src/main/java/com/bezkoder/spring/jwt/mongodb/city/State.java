package com.bezkoder.spring.jwt.mongodb.city;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "state")
public class State {

    private String name;

}
