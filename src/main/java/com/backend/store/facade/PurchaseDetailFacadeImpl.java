package com.backend.store.facade;

import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.PurchaseDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class PurchaseDetailFacadeImpl implements PurchaseDetailFacade {
    @Autowired
    private PurchaseDetailManager purchaseDetailManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.purchaseDetailManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws FacadeException {
        try {
            return this.purchaseDetailManager.selectId(purchaseDetailDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(PurchaseDetailDto purchaseDetailDto) throws FacadeException {
        try {
            this.purchaseDetailManager.insert(purchaseDetailDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(PurchaseDetailDto purchaseDetailDto) throws FacadeException {
        try {
            this.purchaseDetailManager.update(purchaseDetailDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(PurchaseDetailDto purchaseDetailDto) throws FacadeException {
        try {
            this.purchaseDetailManager.delete(purchaseDetailDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
