package com.kite.world.dao;

import com.kite.world.dao.mapper.CityRowMapper;
import com.kite.world.model.City;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CityRepository {
    private static final String SELECT_CLAUSE = "select * from city where 1 = 1";
    private static final String CODE_WHERE = " and countryCode= :countryCode";
    private static final String NAME_WHERE = " and lower(name)= lower(:name)";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<City> getCities(Map<String, Object> params) {
        String codeWhere = params.getOrDefault("countryCode", null) == null
                ? "" : CODE_WHERE;
        String nameWhere = params.getOrDefault("name", null) == null
                ? "" : NAME_WHERE;
        String sql = SELECT_CLAUSE + codeWhere + nameWhere;

        return namedParameterJdbcTemplate.query(sql, params, new CityRowMapper());
    }
}
