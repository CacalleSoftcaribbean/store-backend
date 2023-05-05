package com.backend.store.dao;

import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface CategoryDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public CategoryDto selectId(CategoryDto categoryDto) throws DaoException;
    public void insert(CategoryDto categoryDto) throws DaoException;
    public void update(CategoryDto categoryDto) throws  DaoException;
    public void delete(CategoryDto categoryDto) throws DaoException;
}
