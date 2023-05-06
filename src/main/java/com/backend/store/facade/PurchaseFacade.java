package com.backend.store.facade;

import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface PurchaseFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws FacadeException;
    public void insert(PurchaseDto purchaseDto) throws FacadeException;
    public void update(PurchaseDto purchaseDto) throws FacadeException;
    public void delete(PurchaseDto purchaseDto) throws FacadeException;
}
