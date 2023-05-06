package com.backend.store.mapper;

import com.backend.store.dto.PersonDto;
import com.backend.store.dto.PurchaseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseMapper implements RowMapper<PurchaseDto> {

    @Override
    public PurchaseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PurchaseDto purchaseDto = new PurchaseDto();
        PersonDto personDto = new PersonDto();
        purchaseDto.setIdPurchase(rs.getInt("id_purchase"));
        personDto.setIdPerson(rs.getInt("person_id"));
        purchaseDto.setPersonDto(personDto);
        purchaseDto.setDatePurchase(rs.getDate("date_purchase"));
        purchaseDto.setStatus(rs.getString("status"));
        purchaseDto.setTypePayment(rs.getString("type_payment"));
        purchaseDto.setIdTransaction(rs.getString("id_transaction"));
        purchaseDto.setReference(rs.getString("reference"));
        return purchaseDto;
    }
}
