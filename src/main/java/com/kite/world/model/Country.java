package com.kite.world.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Double surfaceArea;
    private Short indepYear;
    private Long population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private String capital;
    private String code2;
}
