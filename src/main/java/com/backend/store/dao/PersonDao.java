package com.backend.store.dao;

import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public PersonDto selectId(PersonDto personDto) throws DaoException;
    public PersonDto insert(PersonDto personDto) throws DaoException;
    public void update(PersonDto personDto) throws  DaoException;
    public void delete(PersonDto personDto) throws DaoException;
}
