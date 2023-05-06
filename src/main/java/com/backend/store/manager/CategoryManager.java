package com.backend.store.manager;

import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface CategoryManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public CategoryDto selectId(CategoryDto categoryDto) throws ManagerException;
    public void insert(CategoryDto categoryDto) throws ManagerException;
    public void update(CategoryDto categoryDto) throws ManagerException;
    public void delete(CategoryDto categoryDto) throws ManagerException;
}
