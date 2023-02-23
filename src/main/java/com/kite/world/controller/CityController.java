package com.kite.world.controller;

import com.kite.world.dao.CityRepository;
import com.kite.world.model.City;
import com.kite.world.model.CityRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/city")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public ResponseEntity<?> getCities(
            @RequestBody(required = false) CityRequest cityRequest
    ) {
        Map<String, Object> params = new HashMap<>();
        if (cityRequest != null) {
            params.put("countryCode", cityRequest.getCountryCode());
            params.put("name", cityRequest.getName());
        }

        List<City> cities = cityRepository.getCities(params);

        return ResponseEntity.ok(cities);
    }

}
