package com.backend.store.facade;

import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface AddressFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public AddressDto selectId(AddressDto addressDto) throws FacadeException;
    public void insert(AddressDto addressDto) throws FacadeException;
    public void update(AddressDto addressDto) throws FacadeException;
    public void delete(AddressDto addressDto) throws FacadeException;
}
