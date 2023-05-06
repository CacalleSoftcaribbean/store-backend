package com.backend.store.dao;

import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.CartMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {
    private JdbcTemplate jdbcTemplate;

    public CartDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_cart, " +
                        "person_id, " +
                        "product_id, " +
                        "quantity " +
                        "FROM carts;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public CartDto selectId(CartDto cartDto) throws DaoException {
        String SQL = "SELECT id_cart, " +
                        "person_id, " +
                        "product_id, " +
                        "quantity " +
                        "FROM carts " +
                        "WHERE id_cart=?;";
        CartDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new CartMapper(), cartDto.getIdCart());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(CartDto cartDto) throws DaoException {
        String SQL = "INSERT INTO carts(person_id, " +
                        "product_id, " +
                        "quantity) " +
                        "VALUES (?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    cartDto.getPersonDto().getIdPerson(),
                    cartDto.getProductDto().getIdProduct(),
                    cartDto.getQuantity()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(CartDto cartDto) throws DaoException {
        String SQL = "UPDATE carts SET person_id=?, " +
                        "product_id=?, " +
                        "quantity=? " +
                        "WHERE id_cart=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    cartDto.getPersonDto().getIdPerson(),
                    cartDto.getProductDto().getIdProduct(),
                    cartDto.getQuantity(),
                    cartDto.getIdCart()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(CartDto cartDto) throws DaoException {
        String SQL = "DELETE FROM carts WHERE id_cart=?;";
        try {
            this.jdbcTemplate.update(SQL, cartDto.getIdCart());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
