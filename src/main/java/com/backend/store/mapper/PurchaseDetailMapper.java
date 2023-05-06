package com.backend.store.mapper;

import com.backend.store.dto.ProductDto;
import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.dto.PurchaseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDetailMapper implements RowMapper<PurchaseDetailDto> {
    @Override
    public PurchaseDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PurchaseDetailDto purchaseDetailDto = new PurchaseDetailDto();
        ProductDto productDto = new ProductDto();
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDetailDto.setIdPurchaseDetail(rs.getInt("id_purchase_detail"));
        productDto.setIdProduct(rs.getInt("product_id"));
        purchaseDetailDto.setProductDto(productDto);
        purchaseDto.setIdPurchase(rs.getInt("purchase_id"));
        purchaseDetailDto.setPurchaseDto(purchaseDto);
        purchaseDetailDto.setQuantity(rs.getInt("quantity"));
        purchaseDetailDto.setPrice(rs.getDouble("price"));
        return purchaseDetailDto;
    }
}
