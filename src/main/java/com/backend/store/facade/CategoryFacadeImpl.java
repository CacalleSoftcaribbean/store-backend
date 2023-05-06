package com.backend.store.facade;

import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class CategoryFacadeImpl implements CategoryFacade {
    @Autowired
    private CategoryManager categoryManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.categoryManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public CategoryDto selectId(CategoryDto categoryDto) throws FacadeException {
        try {
            return this.categoryManager.selectId(categoryDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(CategoryDto categoryDto) throws FacadeException {
        try {
            this.categoryManager.insert(categoryDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(CategoryDto categoryDto) throws FacadeException {
        try {
            this.categoryManager.update(categoryDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(CategoryDto categoryDto) throws FacadeException {
        try {
            this.categoryManager.delete(categoryDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
