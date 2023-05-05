package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface AddressDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public AddressDto selectId(AddressDto addressDto) throws DaoException;
    public void insert(AddressDto addressDto) throws DaoException;
    public void update(AddressDto addressDto) throws  DaoException;
    public void delete(AddressDto addressDto) throws DaoException;
}
