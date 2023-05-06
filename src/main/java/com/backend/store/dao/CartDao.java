package com.backend.store.dao;

import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface CartDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public CartDto selectId(CartDto cartDto) throws DaoException;
    public void insert(CartDto cartDto) throws DaoException;
    public void update(CartDto cartDto) throws  DaoException;
    public void delete(CartDto cartDto) throws DaoException;
}
