package com.backend.store.dao;

import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public interface PurchaseDetailDao {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws DaoException;
    public void insert(PurchaseDetailDto purchaseDetailDto) throws DaoException;
    public void update(PurchaseDetailDto purchaseDetailDto) throws  DaoException;
    public void delete(PurchaseDetailDto purchaseDetailDto) throws DaoException;
}
