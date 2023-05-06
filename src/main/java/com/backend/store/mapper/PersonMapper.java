package com.backend.store.mapper;

import com.backend.store.dto.PersonDto;
import com.backend.store.dto.RolDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonDto> {
    @Override
    public PersonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonDto personDto = new PersonDto();
        RolDto rolDto = new RolDto();
        personDto.setIdPerson(rs.getInt("id_person"));
        rolDto.setIdRol(rs.getInt("rol_id"));
        personDto.setRolDto(rolDto);
        personDto.setFirstName(rs.getString("first_name"));
        personDto.setSecondName(rs.getString("second_name"));
        personDto.setFirstLastname(rs.getString("first_lastname"));
        personDto.setSecondLastname(rs.getString("second_lastname"));
        personDto.setPhone(rs.getString("phone"));
        personDto.setEmail(rs.getString("email"));
        personDto.setDateBirth(rs.getDate("date_birth"));
        return personDto;
    }
}
