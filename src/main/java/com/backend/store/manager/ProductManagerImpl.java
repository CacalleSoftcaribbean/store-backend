package com.backend.store.manager;

import com.backend.store.dao.ProductDao;
import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductManagerImpl implements ProductManager{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.productDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public ProductDto selectId(ProductDto productDto) throws ManagerException {
        try {
            return this.productDao.selectId(productDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(ProductDto productDto) throws ManagerException {
        try {
            ProductDto temp = this.productDao.selectId(productDto);
            if(temp==null){
                this.productDao.insert(productDto);
            }else{
                this.productDao.update(productDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(ProductDto productDto) throws ManagerException {
        try {
            ProductDto temp = this.productDao.selectId(productDto);
            if(temp!=null){
                this.productDao.update(productDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(ProductDto productDto) throws ManagerException {
        try {
            ProductDto temp = this.productDao.selectId(productDto);
            if(temp!=null) {
                this.productDao.delete(productDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
