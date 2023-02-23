package com.kite.world.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CountryRequest {
    private String code;
    private String name;
}
