package com.backend.store.manager;

import com.backend.store.dao.RolDao;
import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RolManagerImpl implements RolManager {
    @Autowired
    private RolDao rolDao;

    public RolManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.rolDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public RolDto selectId(RolDto rolDto) throws ManagerException {
        try {
            return this.rolDao.selectId(rolDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(RolDto rolDto) throws ManagerException {
        try {
            RolDto temp = this.rolDao.selectId(rolDto);
            if(temp==null){
                this.rolDao.insert(rolDto);
            }else{
                this.rolDao.update(rolDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(RolDto rolDto) throws ManagerException {
        try {
            RolDto temp = this.rolDao.selectId(rolDto);
            if(temp!=null){
                this.rolDao.update(rolDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(RolDto rolDto) throws ManagerException {
        try {
            RolDto temp = this.rolDao.selectId(rolDto);
            if(temp!=null) {
                this.rolDao.delete(rolDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
