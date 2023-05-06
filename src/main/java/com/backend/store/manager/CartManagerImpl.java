package com.backend.store.manager;

import com.backend.store.dao.CartDao;
import com.backend.store.dto.CartDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CartManagerImpl implements  CartManager {
    @Autowired
    private CartDao cartDao;

    public CartManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.cartDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public CartDto selectId(CartDto cartDto) throws ManagerException {
        try {
            return this.cartDao.selectId(cartDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(CartDto cartDto) throws ManagerException {
        try {
            CartDto temp = this.cartDao.selectId(cartDto);
            if(temp==null){
                this.cartDao.insert(cartDto);
            }else{
                this.cartDao.update(cartDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(CartDto cartDto) throws ManagerException {
        try {
            CartDto temp = this.cartDao.selectId(cartDto);
            if(temp!=null){
                this.cartDao.update(cartDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(CartDto cartDto) throws ManagerException {
        try {
            CartDto temp = this.cartDao.selectId(cartDto);
            if(temp!=null) {
                this.cartDao.delete(cartDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
