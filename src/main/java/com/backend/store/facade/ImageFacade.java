package com.backend.store.facade;

import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface ImageFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public ImageDto selectId(ImageDto imageDto) throws FacadeException;
    public void insert(ImageDto imageDto) throws FacadeException;
    public void update(ImageDto imageDto) throws FacadeException;
    public void delete(ImageDto imageDto) throws FacadeException;
}
