package com.backend.store.facade;

import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface CartFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public CartDto selectId(CartDto cartDto) throws FacadeException;
    public void insert(CartDto cartDto) throws FacadeException;
    public void update(CartDto cartDto) throws FacadeException;
    public void delete(CartDto cartDto) throws FacadeException;
}
