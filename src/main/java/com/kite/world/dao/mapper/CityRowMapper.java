package com.kite.world.dao.mapper;

import com.kite.world.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();

        city.setName(rs.getString("Name"));
        city.setCountryCode(rs.getString("CountryCode"));
        city.setDistrict(rs.getString("District"));
        city.setPopulation(rs.getLong("Population"));

        return city;
    }
}
