package com.backend.store.facade;

import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.FacadeException;

import java.util.List;
import java.util.Map;

public interface PurchaseDetailFacade {
    public List<Map<String, Object>> selectAll() throws FacadeException;
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws FacadeException;
    public void insert(PurchaseDetailDto purchaseDetailDto) throws FacadeException;
    public void update(PurchaseDetailDto purchaseDetailDto) throws FacadeException;
    public void delete(PurchaseDetailDto purchaseDetailDto) throws FacadeException;
}
