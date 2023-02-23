package com.kite.world.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CountryLanguage {
    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Double percentage;
}
