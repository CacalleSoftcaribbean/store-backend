package com.backend.store.mapper;

import com.backend.store.dto.CategoryDto;
import com.backend.store.dto.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();
        CategoryDto categoryDto = new CategoryDto();
        productDto.setIdProduct(rs.getInt("id_product"));
        categoryDto.setIdCategory(rs. getInt("category_id"));
        productDto.setCategoryDto(categoryDto);
        productDto.setName(rs.getString("name"));
        productDto.setImage(rs.getString("image"));
        productDto.setDescription(rs.getString("description"));
        productDto.setPrice(rs.getDouble("price"));
        productDto.setStock(rs.getInt("stock"));
        productDto.setBrand(rs.getString("brand"));
        productDto.setModel(rs.getString("model"));
        productDto.setStatus(rs.getString("status"));
        return productDto;
    }
}
