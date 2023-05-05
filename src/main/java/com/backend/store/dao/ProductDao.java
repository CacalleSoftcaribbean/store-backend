package com.backend.store.dao;

import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public ProductDto selectId(ProductDto productDto) throws DaoException;
    public void insert(ProductDto productDto) throws DaoException;
    public void update(ProductDto productDto) throws  DaoException;
    public void delete(ProductDto productDto) throws DaoException;
}
