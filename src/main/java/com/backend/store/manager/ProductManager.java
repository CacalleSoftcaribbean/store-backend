package com.backend.store.manager;

import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface ProductManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public ProductDto selectId(ProductDto productDto) throws ManagerException;
    public void insert(ProductDto productDto) throws ManagerException;
    public void update(ProductDto productDto) throws ManagerException;
    public void delete(ProductDto productDto) throws ManagerException;
}
