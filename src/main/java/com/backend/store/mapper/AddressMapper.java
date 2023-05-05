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
        PersonDto personDto = new PersonDto();
        addressDto.setIdAddress(rs.getInt("id_address"));
        personDto.setIdPerson(rs.getInt("person_id"));
        addressDto.setPersonDto(personDto);
        addressDto.setAddress(rs.getString("address"));
        addressDto.setCity(rs.getString("city"));
        addressDto.setCountry(rs.getString("country"));
        addressDto.setPostalCode(rs.getString("postal_code"));
        return addressDto;
    }
}
