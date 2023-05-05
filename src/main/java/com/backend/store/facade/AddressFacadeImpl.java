package com.backend.store.facade;

import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component
@Transactional
public class AddressFacadeImpl implements AddressFacade {
    @Autowired
    private AddressManager addressManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.addressManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public AddressDto selectId(AddressDto addressDto) throws FacadeException {
        try {
            return this.addressManager.selectId(addressDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(AddressDto addressDto) throws FacadeException {
        try {
            this.addressManager.insert(addressDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(AddressDto addressDto) throws FacadeException {
        try {
            this.addressManager.update(addressDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(AddressDto addressDto) throws FacadeException {
        try {
            this.addressManager.delete(addressDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
