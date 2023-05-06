package com.backend.store.manager;

import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface UserManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public UserDto selectId(UserDto userDto) throws ManagerException;
    public void insert(UserDto userDto) throws ManagerException;
    public void update(UserDto userDto) throws ManagerException;
    public void delete(UserDto userDto) throws ManagerException;
}
