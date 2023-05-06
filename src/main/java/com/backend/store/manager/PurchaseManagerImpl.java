package com.backend.store.manager;

import com.backend.store.dao.PurchaseDao;
import com.backend.store.dto.AddressDto;
import com.backend.store.dto.PurchaseDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PurchaseManagerImpl implements PurchaseManager {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.purchaseDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public PurchaseDto selectId(PurchaseDto purchaseDto) throws ManagerException {
        try {
            return this.purchaseDao.selectId(purchaseDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(PurchaseDto purchaseDto) throws ManagerException {
        try {
            PurchaseDto temp = this.purchaseDao.selectId(purchaseDto);
            if(temp==null){
                this.purchaseDao.insert(purchaseDto);
            }else{
                this.purchaseDao.update(purchaseDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(PurchaseDto purchaseDto) throws ManagerException {
        try {
            PurchaseDto temp = this.purchaseDao.selectId(purchaseDto);
            if(temp!=null){
                this.purchaseDao.update(purchaseDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(PurchaseDto purchaseDto) throws ManagerException {
        try {
            PurchaseDto temp = this.purchaseDao.selectId(purchaseDto);
            if(temp!=null) {
                this.purchaseDao.delete(purchaseDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
