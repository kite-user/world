package com.kite.world.dao.mapper;

import com.kite.world.model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setCode(rs.getString("Code"));
        country.setName(rs.getString("Name"));
        country.setContinent(rs.getString("Continent"));
        country.setRegion(rs.getString("Region"));
        country.setSurfaceArea(rs.getDouble("SurfaceArea"));
        country.setIndepYear(rs.getShort("IndepYear"));
        country.setPopulation(rs.getLong("Population"));
        country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
        country.setGnp(rs.getDouble("GNP"));
        country.setGnpOld(rs.getDouble("GNPOld"));
        country.setLocalName(rs.getString("LocalName"));
        country.setGovernmentForm(rs.getString("GovernmentForm"));
        country.setHeadOfState(rs.getString("HeadOfState"));
        country.setCapital(rs.getString("Capital"));
        country.setCode2(rs.getString("Code2"));

        return country;
    }
}
