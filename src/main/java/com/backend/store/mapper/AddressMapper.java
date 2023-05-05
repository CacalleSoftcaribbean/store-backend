package com.backend.store.mapper;

import com.backend.store.dto.AddressDto;
import com.backend.store.dto.PersonDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AddressMapper implements RowMapper<AddressDto> {

    @Override
    public AddressDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        AddressDto addressDto = new AddressDto();
        addressDto.setIdAddress(rs.getInt("id_address"));
        addressDto.setPersonDto((PersonDto) rs.getObject("person_id"));
        addressDto.setAddress(rs.getString("address"));
        addressDto.setCity(rs.getString("city"));
        addressDto.setCountry(rs.getString("country"));
        addressDto.setPostalCode(rs.getString("postal_code"));
        return addressDto;
    }
}
