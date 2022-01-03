package com.bezkoder.spring.jwt.mongodb.city;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCity {
    private int id;
    private int stateId;
    private String city;
}
