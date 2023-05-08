package com.backend.store.dao;

import com.backend.store.date.UtilDate;
import com.backend.store.dto.AddressDto;
import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import com.backend.store.mapper.PurchaseMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PurchaseDaoImpl implements PurchaseDao{
    private JdbcTemplate jdbcTemplate;

    public PurchaseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_purchase, " +
                        "person_id, " +
                        "date_purchase, " +
                        "status, " +
                        "type_payment, " +
                        "id_transaction, " +
                        "reference " +
                        "FROM purchases;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws DaoException {
        String SQL = "SELECT id_purchase, " +
                            "person_id, " +
                            "date_purchase, " +
                            "status, " +
                            "type_payment, " +
                            "id_transaction, " +
                            "reference " +
                            "FROM purchases " +
                            "WHERE id_purchase=?;";
        PurchaseDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new PurchaseMapper(), purchaseDto.getIdPurchase());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(PurchaseDto purchaseDto) throws DaoException {
        String SQL = "INSERT INTO purchases(person_id, " +
                        "date_purchase, " +
                        "status, " +
                        "type_payment, " +
                        "id_transaction, " +
                        "reference) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    purchaseDto.getPersonDto().getIdPerson(),
                    UtilDate.toSqlDate(purchaseDto.getDatePurchase()),
                    purchaseDto.getStatus(),
                    purchaseDto.getTypePayment(),
                    purchaseDto.getIdTransaction(),
                    purchaseDto.getReference()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(PurchaseDto purchaseDto) throws DaoException {
        String SQL = "UPDATE purchases SET " +
                        "person_id=?, " +
                        "date_purchase=? " +
                        "status=?, " +
                        "type_payment=?, " +
                        "id_transaction=?, " +
                        "reference=?, " +
                        "WHERE id_purchase=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    purchaseDto.getPersonDto().getIdPerson(),
                    UtilDate.toSqlDate(purchaseDto.getDatePurchase()),
                    purchaseDto.getStatus(),
                    purchaseDto.getTypePayment(),
                    purchaseDto.getIdTransaction(),
                    purchaseDto.getReference(),
                    purchaseDto.getIdPurchase()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(PurchaseDto purchaseDto) throws DaoException {
        String SQL = "DELETE FROM purchases WHERE id_purchase=?;";
        try {
            this.jdbcTemplate.update(SQL, purchaseDto.getIdPurchase());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
