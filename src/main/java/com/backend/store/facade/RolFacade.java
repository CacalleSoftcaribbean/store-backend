package com.backend.store.facade;

import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface RolFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public RolDto selectId(RolDto rolDto) throws FacadeException;
    public void insert(RolDto rolDto) throws FacadeException;
    public void update(RolDto rolDto) throws FacadeException;
    public void delete(RolDto rolDto) throws FacadeException;
}
