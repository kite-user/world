package com.kite.world.controller;

import com.kite.world.dao.CountryLanguageRepository;
import com.kite.world.model.CountryLanguage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/language")
public class CountryLanguageController {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageController(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @GetMapping
    public ResponseEntity<?> getLanguage(
            @RequestBody(required = false) String code
    ) {
        Map<String, Object> params = new HashMap<>();
        if (code != null)
            params.put("countryCode", code);

        List<CountryLanguage> languages = countryLanguageRepository.getLanguages(params);
        return ResponseEntity.ok(languages);
    }
}
