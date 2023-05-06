package com.backend.store.facade;

import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class CartFacadeImpl implements CartFacade {
    @Autowired
    private CartManager cartManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.cartManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public CartDto selectId(CartDto cartDto) throws FacadeException {
        try {
            return this.cartManager.selectId(cartDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(CartDto cartDto) throws FacadeException {
        try {
            this.cartManager.insert(cartDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(CartDto cartDto) throws FacadeException {
        try {
            this.cartManager.update(cartDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(CartDto cartDto) throws FacadeException {
        try {
            this.cartManager.delete(cartDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
