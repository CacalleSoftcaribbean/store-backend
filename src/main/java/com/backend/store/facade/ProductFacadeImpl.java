package com.backend.store.facade;

import com.backend.store.dto.ProductDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductManager productManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.productManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public ProductDto selectId(ProductDto productDto) throws FacadeException {
        try {
            return this.productManager.selectId(productDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(ProductDto productDto) throws FacadeException {
        try {
            this.productManager.insert(productDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(ProductDto productDto) throws FacadeException {
        try {
            this.productManager.update(productDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(ProductDto productDto) throws FacadeException {
        try {
            this.productManager.delete(productDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
