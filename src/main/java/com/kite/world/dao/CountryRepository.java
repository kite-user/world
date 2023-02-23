package com.kite.world.dao;

import com.kite.world.dao.mapper.CountryRowMapper;
import com.kite.world.model.Country;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CountryRepository {
    private final String SELECT_CLAUSE = "select * from country where 1 = 1";
    private final String CODE_WHERE_CLAUSE = " and code= :code";
    private final String NAME_WHERE_CLAUSE = " and lower(name)= :name";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CountryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Country> getCountries(Map<String, Object> params) {
        String codeWhere = params.getOrDefault("code", null) == null
                ? "" : CODE_WHERE_CLAUSE;
        String nameWhere = params.getOrDefault("name", null) == null
                ? "" : NAME_WHERE_CLAUSE;

        String sql = SELECT_CLAUSE + codeWhere + nameWhere;

        return namedParameterJdbcTemplate.query(sql, params, new CountryRowMapper());
    }
}
