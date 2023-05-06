package com.backend.store.manager;

import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface ImageManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public ImageDto selectId(ImageDto imageDto) throws ManagerException;
    public void insert(ImageDto imageDto) throws ManagerException;
    public void update(ImageDto imageDto) throws ManagerException;
    public void delete(ImageDto imageDto) throws ManagerException;
}
