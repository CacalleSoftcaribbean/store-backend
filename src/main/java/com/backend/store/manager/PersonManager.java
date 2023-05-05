package com.backend.store.manager;

import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface PersonManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public PersonDto selectId(PersonDto personDto) throws ManagerException;
    public void insert(PersonDto personDto) throws ManagerException;
    public void update(PersonDto personDto) throws ManagerException;
    public void delete(PersonDto personDto) throws ManagerException;
}
