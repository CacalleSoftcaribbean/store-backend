package com.backend.store.dao;

import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public UserDto selectId(UserDto userDto) throws DaoException;
    public void insert(UserDto userDto) throws DaoException;
    public void update(UserDto userDto) throws  DaoException;
    public void delete(UserDto userDto) throws DaoException;
}
