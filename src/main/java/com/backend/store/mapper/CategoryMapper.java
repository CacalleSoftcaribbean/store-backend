package com.backend.store.mapper;

import com.backend.store.dao.CategoryDao;
import com.backend.store.dto.CategoryDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryDto> {
    @Override
    public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setIdCategory(rs.getInt("id_category"));
        categoryDto.setName(rs.getString("name"));
        categoryDto.setDescription(rs.getString("description"));
        return categoryDto;
    }
}
