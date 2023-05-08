package com.backend.store.mapper;

import com.backend.store.dto.RolDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolMapper implements RowMapper<RolDto> {

    @Override
    public RolDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        RolDto rolDto = new RolDto();
        rolDto.setIdRol(rs.getInt("id_rol"));
        rolDto.setName(rs.getString("name"));
        rolDto.setDescription(rs.getString("description"));
        rolDto.setStatus(rs.getInt("status"));
        return rolDto;
    }
}
