package com.backend.store.manager;

import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.ManagerException;

import java.util.List;
import java.util.Map;

public interface PurchaseManager {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws ManagerException;
    public void insert(PurchaseDto purchaseDto) throws ManagerException;
    public void update(PurchaseDto purchaseDto) throws ManagerException;
    public void delete(PurchaseDto purchaseDto) throws ManagerException;
}
