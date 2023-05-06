package com.backend.store.manager;

import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface CartManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public CartDto selectId(CartDto cartDto) throws ManagerException;
    public void insert(CartDto cartDto) throws ManagerException;
    public void update(CartDto cartDto) throws ManagerException;
    public void delete(CartDto cartDto) throws ManagerException;
}
