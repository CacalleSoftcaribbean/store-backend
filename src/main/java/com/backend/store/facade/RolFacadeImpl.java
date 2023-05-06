package com.backend.store.facade;

import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.RolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class RolFacadeImpl implements RolFacade {
    @Autowired
    private RolManager rolManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.rolManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public RolDto selectId(RolDto rolDto) throws FacadeException {
        try {
            return this.rolManager.selectId(rolDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(RolDto rolDto) throws FacadeException {
        try {
            this.rolManager.insert(rolDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(RolDto rolDto) throws FacadeException {
        try {
            this.rolManager.update(rolDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(RolDto rolDto) throws FacadeException {
        try {
            this.rolManager.delete(rolDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
