package com.backend.store.manager;

import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface PurchaseDetailManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws ManagerException;
    public void insert(PurchaseDetailDto purchaseDetailDto) throws ManagerException;
    public void update(PurchaseDetailDto purchaseDetailDto) throws ManagerException;
    public void delete(PurchaseDetailDto purchaseDetailDto) throws ManagerException;
}
