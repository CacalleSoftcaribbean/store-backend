package com.backend.store.manager;

import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface RolManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public RolDto selectId(RolDto rolDto) throws ManagerException;
    public void insert(RolDto rolDto) throws ManagerException;
    public void update(RolDto rolDto) throws ManagerException;
    public void delete(RolDto rolDto) throws ManagerException;
}
