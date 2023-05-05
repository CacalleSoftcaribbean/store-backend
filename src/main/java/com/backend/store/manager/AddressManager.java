package com.backend.store.manager;

import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface AddressManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public AddressDto selectId(AddressDto addressDto) throws ManagerException;
    public void insert(AddressDto addressDto) throws ManagerException;
    public void update(AddressDto addressDto) throws ManagerException;
    public void delete(AddressDto addressDto) throws ManagerException;
}
