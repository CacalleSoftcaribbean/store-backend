package com.backend.store.facade;

import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface PersonFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public PersonDto selectId(PersonDto personDto) throws FacadeException;
    public void insert(PersonDto personDto) throws FacadeException;
    public void update(PersonDto personDto) throws FacadeException;
    public void delete(PersonDto personDto) throws FacadeException;
}
