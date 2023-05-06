package com.backend.store.mapper;

import com.backend.store.dto.ImageDto;
import com.backend.store.dto.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<ImageDto> {

    @Override
    public ImageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ImageDto imageDto = new ImageDto();
        ProductDto productDto = new ProductDto();
        imageDto.setIdImage(rs.getInt("id_image"));
        productDto.setIdProduct(rs.getInt("product_id"));
        imageDto.setProductDto(productDto);
        imageDto.setImage(rs.getString("image"));
        return imageDto;
    }
}
