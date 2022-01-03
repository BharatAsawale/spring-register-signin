package com.bezkoder.spring.jwt.mongodb.city;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class StateCities {
    private List<State> states;
    private List<City> cities;
}
