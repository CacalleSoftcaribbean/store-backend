package com.backend.store.manager;

import com.backend.store.dao.PurchaseDetailDao;
import com.backend.store.dto.AddressDto;
import com.backend.store.dto.PurchaseDetailDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PurchaseDetailManagerImpl implements PurchaseDetailManager {
    @Autowired
    private PurchaseDetailDao purchaseDetailDao;

    public PurchaseDetailManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.purchaseDetailDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public PurchaseDetailDto selectId(PurchaseDetailDto purchaseDetailDto) throws ManagerException {
        try {
            return this.purchaseDetailDao.selectId(purchaseDetailDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(PurchaseDetailDto purchaseDetailDto) throws ManagerException {
        try {
            PurchaseDetailDto temp = this.purchaseDetailDao.selectId(purchaseDetailDto);
            if(temp==null){
                this.purchaseDetailDao.insert(purchaseDetailDto);
            }else{
                this.purchaseDetailDao.update(purchaseDetailDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(PurchaseDetailDto purchaseDetailDto) throws ManagerException {
        try {
            PurchaseDetailDto temp = this.purchaseDetailDao.selectId(purchaseDetailDto);
            if(temp!=null){
                this.purchaseDetailDao.update(purchaseDetailDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(PurchaseDetailDto purchaseDetailDto) throws ManagerException {
        try {
            PurchaseDetailDto temp = this.purchaseDetailDao.selectId(purchaseDetailDto);
            if(temp!=null) {
                this.purchaseDetailDao.delete(purchaseDetailDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
