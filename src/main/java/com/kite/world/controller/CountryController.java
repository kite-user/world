package com.kite.world.controller;

import com.kite.world.dao.CountryRepository;
import com.kite.world.model.Country;
import com.kite.world.model.CountryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public ResponseEntity<?> getCountries(
            @RequestBody(required = false) CountryRequest countryRequest
    ) {
        Map<String, Object> params = new HashMap<>();
        if (countryRequest != null) {
            params.put("code", countryRequest.getCode());
            params.put("name", countryRequest.getName());
        }
        List<Country> countries = countryRepository.getCountries(params);

        return ResponseEntity.ok().body(countries);
    }
}
