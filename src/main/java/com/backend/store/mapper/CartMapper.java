package com.backend.store.mapper;

import com.backend.store.dto.CartDto;
import com.backend.store.dto.PersonDto;
import com.backend.store.dto.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<CartDto> {

    @Override
    public CartDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CartDto cartDto = new CartDto();
        PersonDto personDto = new PersonDto();
        ProductDto productDto = new ProductDto();
        cartDto.setIdCart(rs.getInt("id_cart"));
        personDto.setIdPerson(rs.getInt("person_id"));
        cartDto.setPersonDto(personDto);
        productDto.setIdProduct(rs.getInt("product_id"));
        cartDto.setProductDto(productDto);
        cartDto.setQuantity(rs.getDouble("quantity"));
        return cartDto;
    }
}
