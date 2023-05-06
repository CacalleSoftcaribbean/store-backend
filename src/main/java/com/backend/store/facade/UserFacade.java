package com.backend.store.facade;

import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface UserFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public UserDto selectId(UserDto userDto) throws FacadeException;
    public void insert(UserDto userDto) throws FacadeException;
    public void update(UserDto userDto) throws FacadeException;
    public void delete(UserDto userDto) throws FacadeException;
}
