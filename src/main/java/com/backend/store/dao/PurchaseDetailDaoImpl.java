package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import com.backend.store.mapper.PurchaseDetailMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PurchaseDetailDaoImpl implements PurchaseDetailDao {
    private JdbcTemplate jdbcTemplate;

    public PurchaseDetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_purchase_detail, " +
                        "product_id, " +
                        "purchase_id, " +
                        "quantity " +
                        "FROM purchases_details;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws DaoException {
        String SQL = "SELECT id_purchase_detail, " +
                        "product_id, " +
                        "purchase_id, " +
                        "quantity FROM " +
                        "purchases_details " +
                        "WHERE id_purchase_detail=?;";
        PurchaseDetailDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new PurchaseDetailMapper(), purchaseDetailDto.getIdPurchaseDetail());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(PurchaseDetailDto purchaseDetailDto) throws DaoException {
        String SQL = "INSERT INTO purchases_details(product_id, " +
                        "purchase_id, " +
                        "quantity) " +
                        "VALUES (?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    purchaseDetailDto.getProductDto().getIdProduct(),
                    purchaseDetailDto.getPurchaseDto().getIdPurchase(),
                    purchaseDetailDto.getQuantity()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(PurchaseDetailDto purchaseDetailDto) throws DaoException {
        String SQL = "UPDATE purchases_details SET product_id=?, " +
                        "purchase_id=?, " +
                        "quantity=? " +
                        "WHERE id_purchase_detail=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    purchaseDetailDto.getProductDto().getIdProduct(),
                    purchaseDetailDto.getPurchaseDto().getIdPurchase(),
                    purchaseDetailDto.getQuantity(),
                    purchaseDetailDto.getIdPurchaseDetail()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(PurchaseDetailDto purchaseDetailDto) throws DaoException {
        String SQL = "DELETE FROM purchases_details WHERE id_purchase_detail=?;";
        try {
            this.jdbcTemplate.update(SQL, purchaseDetailDto.getIdPurchaseDetail());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
