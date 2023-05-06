package com.backend.store.dao;

import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface RolDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public RolDto selectId(RolDto rolDto) throws DaoException;
    public void insert(RolDto rolDto) throws DaoException;
    public void update(RolDto rolDto) throws  DaoException;
    public void delete(RolDto rolDto) throws DaoException;
}
