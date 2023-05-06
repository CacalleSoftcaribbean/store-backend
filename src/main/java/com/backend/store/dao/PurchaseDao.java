package com.backend.store.dao;


import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface PurchaseDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws DaoException;
    public void insert(PurchaseDto purchaseDto) throws DaoException;
    public void update(PurchaseDto purchaseDto) throws  DaoException;
    public void delete(PurchaseDto purchaseDto) throws DaoException;
}
