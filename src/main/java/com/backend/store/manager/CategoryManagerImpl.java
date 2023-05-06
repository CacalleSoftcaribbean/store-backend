package com.backend.store.manager;

import com.backend.store.dao.CategoryDao;
import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CategoryManagerImpl implements CategoryManager{
    @Autowired
    private CategoryDao categoryDao;

    public CategoryManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.categoryDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public CategoryDto selectId(CategoryDto categoryDto) throws ManagerException {
        try {
            return this.categoryDao.selectId(categoryDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(CategoryDto categoryDto) throws ManagerException {
        try {
            CategoryDto temp = this.categoryDao.selectId(categoryDto);
            if(temp==null){
                this.categoryDao.insert(categoryDto);
            }else{
                this.categoryDao.update(categoryDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(CategoryDto categoryDto) throws ManagerException {
        try {
            CategoryDto temp = this.categoryDao.selectId(categoryDto);
            if(temp!=null){
                this.categoryDao.update(categoryDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(CategoryDto categoryDto) throws ManagerException {
        try {
            CategoryDto temp = this.categoryDao.selectId(categoryDto);
            if(temp!=null) {
                this.categoryDao.delete(categoryDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
