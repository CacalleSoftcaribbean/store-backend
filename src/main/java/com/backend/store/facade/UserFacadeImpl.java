package com.backend.store.facade;

import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserManager userManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.userManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public UserDto selectId(UserDto userDto) throws FacadeException {
        try {
            return this.userManager.selectId(userDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(UserDto userDto) throws FacadeException {
        try {
            this.userManager.insert(userDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(UserDto userDto) throws FacadeException {
        try {
            this.userManager.update(userDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(UserDto userDto) throws FacadeException {
        try {
            this.userManager.delete(userDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
