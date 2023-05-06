package com.backend.store.facade;

import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface CategoryFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public CategoryDto selectId(CategoryDto categoryDto) throws FacadeException;
    public void insert(CategoryDto categoryDto) throws FacadeException;
    public void update(CategoryDto categoryDto) throws FacadeException;
    public void delete(CategoryDto categoryDto) throws FacadeException;
}
