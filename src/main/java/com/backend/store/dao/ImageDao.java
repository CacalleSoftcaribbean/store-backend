package com.backend.store.dao;

import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface ImageDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public ImageDto selectId(ImageDto imageDto) throws DaoException;
    public void insert(ImageDto imageDto) throws DaoException;
    public void update(ImageDto imageDto) throws  DaoException;
    public void delete(ImageDto imageDto) throws DaoException;
}
