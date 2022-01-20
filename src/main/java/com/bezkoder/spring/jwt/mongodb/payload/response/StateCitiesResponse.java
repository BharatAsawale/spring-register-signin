package com.bezkoder.spring.jwt.mongodb.payload.response;

import com.bezkoder.spring.jwt.mongodb.city.En.City;
import com.bezkoder.spring.jwt.mongodb.city.En.State;
import lombok.Data;

import java.util.List;

@Data
public class StateCitiesResponse {
    private List<State> states;
    private List<City> cities;
}
