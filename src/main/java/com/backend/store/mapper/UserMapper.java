package com.backend.store.mapper;

import com.backend.store.dto.PersonDto;
import com.backend.store.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        PersonDto personDto = new PersonDto();
        userDto.setIdUser(rs.getInt("id_user"));
        personDto.setIdPerson(rs.getInt("person_id"));
        userDto.setPersonDto(personDto);
        userDto.setUsername(rs.getString("username"));
        userDto.setPassword(rs.getString("password"));
        userDto.setToken(rs.getString("token"));
        return userDto;
    }
}
