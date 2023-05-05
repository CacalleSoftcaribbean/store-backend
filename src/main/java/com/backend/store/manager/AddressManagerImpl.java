package com.backend.store.manager;

import com.backend.store.dao.AddressDao;
import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AddressManagerImpl implements AddressManager {
    @Autowired
    private AddressDao addressDao;

    public AddressManagerImpl() {
    }
    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.addressDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public AddressDto selectId(AddressDto addressDto) throws ManagerException {
        try {
            return this.addressDao.selectId(addressDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(AddressDto addressDto) throws ManagerException {
        try {
            AddressDto temp = this.addressDao.selectId(addressDto);
            if(temp==null){
                this.addressDao.insert(addressDto);
            }else{
                this.addressDao.update(addressDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(AddressDto addressDto) throws ManagerException {
        try {
            AddressDto temp = this.addressDao.selectId(addressDto);
            if(temp!=null){
                this.addressDao.update(addressDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(AddressDto addressDto) throws ManagerException {
        try {
            AddressDto temp = this.addressDao.selectId(addressDto);
            if(temp!=null) {
                this.addressDao.delete(addressDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
