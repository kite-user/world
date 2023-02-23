package com.kite.world.dao.mapper;


import com.kite.world.model.Country;
import com.kite.world.model.CountryLanguage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryLanguageRowMapper implements RowMapper<CountryLanguage> {
    @Override
    public CountryLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
        CountryLanguage language = new CountryLanguage();

        language.setCountryCode(rs.getString("CountryCode"));
        language.setLanguage(rs.getString("Language"));
        language.setIsOfficial(rs.getString("IsOfficial").equals("T"));
        language.setPercentage(rs.getDouble("Percentage"));

        return language;
    }
}
