package com.kite.world.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class City {
    private String name;
    private String countryCode;
    private String district;
    private Long population;
}
