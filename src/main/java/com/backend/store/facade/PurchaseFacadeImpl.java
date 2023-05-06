package com.backend.store.facade;

import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.PurchaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class PurchaseFacadeImpl implements PurchaseFacade {
    @Autowired
    private PurchaseManager purchaseManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.purchaseManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws FacadeException {
        try {
            return this.purchaseManager.selectId(purchaseDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(PurchaseDto purchaseDto) throws FacadeException {
        try {
            this.purchaseManager.insert(purchaseDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(PurchaseDto purchaseDto) throws FacadeException {
        try {
            this.purchaseManager.update(purchaseDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(PurchaseDto purchaseDto) throws FacadeException {
        try {
            this.purchaseManager.delete(purchaseDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
