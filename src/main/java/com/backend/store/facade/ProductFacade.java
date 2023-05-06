package com.backend.store.facade;

import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface ProductFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public ProductDto selectId(ProductDto productDto) throws FacadeException;
    public void insert(ProductDto productDto) throws FacadeException;
    public void update(ProductDto productDto) throws FacadeException;
    public void delete(ProductDto productDto) throws FacadeException;
}
