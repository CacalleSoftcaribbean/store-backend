package com.backend.store.dao;

import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.ProductMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_product, " +
                        "category_id, " +
                        "name, " +
                        "image," +
                        "description, " +
                        "price, " +
                        "stock, " +
                        "brand, " +
                        "model, " +
                        "status " +
                        "FROM products;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ProductDto selectId(ProductDto productDto) throws DaoException {
        String SQL = "SELECT id_product, " +
                        "category_id, " +
                        "name, " +
                        "image," +
                        "description, " +
                        "price, " +
                        "stock, " +
                        "brand, " +
                        "model, " +
                        "status " +
                        "FROM products " +
                        "WHERE id_product=?;";
        ProductDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new ProductMapper(), productDto.getIdProduct());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(ProductDto productDto) throws DaoException {
        String SQL = "INSERT INTO products(category_id, " +
                        "name, " +
                        "image, " +
                        "description, " +
                        "price, " +
                        "stock, " +
                        "brand, " +
                        "model, " +
                        "status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    productDto.getCategoryDto().getIdCategory(),
                    productDto.getName(),
                    productDto.getImage(),
                    productDto.getDescription(),
                    productDto.getPrice(),
                    productDto.getStock(),
                    productDto.getBrand(),
                    productDto.getModel(),
                    productDto.getStatus()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(ProductDto productDto) throws DaoException {
        String SQL = "UPDATE products SET category_id=?, " +
                        "name=?, " +
                        "image=?, " +
                        "description=?, " +
                        "price=?, " +
                        "stock=?, " +
                        "brand=?, " +
                        "model=?, " +
                        "status=?, " +
                        "WHERE id_product=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    productDto.getCategoryDto().getIdCategory(),
                    productDto.getName(),
                    productDto.getImage(),
                    productDto.getDescription(),
                    productDto.getPrice(),
                    productDto.getStock(),
                    productDto.getBrand(),
                    productDto.getModel(),
                    productDto.getStatus(),
                    productDto.getIdProduct()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(ProductDto productDto) throws DaoException {
        String SQL = "DELETE FROM products WHERE id_product=?;";
        try {
            this.jdbcTemplate.update(SQL, productDto.getIdProduct());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
