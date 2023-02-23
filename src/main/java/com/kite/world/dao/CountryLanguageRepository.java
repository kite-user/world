package com.kite.world.dao;

import com.kite.world.dao.mapper.CountryLanguageRowMapper;
import com.kite.world.model.CountryLanguage;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CountryLanguageRepository {
    private final String SELECT_CLAUSE = "select * from countrylanguage where 1 = 1";
    private final String CODE_WHERE = " and countryCode= :countryCode";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CountryLanguageRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<CountryLanguage> getLanguages(Map<String, Object> params) {
        String codeWhere = params.getOrDefault("countryCode", null) == null
                ? "" : CODE_WHERE;

        String sql = SELECT_CLAUSE + codeWhere;

        return namedParameterJdbcTemplate.query(sql, params, new CountryLanguageRowMapper());
    }
}
