package com.backend.store.manager;

import com.backend.store.dao.UserDao;
import com.backend.store.dto.AddressDto;
import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDao userDao;

    public UserManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.userDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public UserDto selectId(UserDto userDto) throws ManagerException {
        try {
            return this.userDao.selectId(userDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(UserDto userDto) throws ManagerException {
        try {
            UserDto temp = this.userDao.selectId(userDto);
            if(temp==null){
                this.userDao.insert(userDto);
            }else{
                this.userDao.update(userDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(UserDto userDto) throws ManagerException {
        try {
            UserDto temp = this.userDao.selectId(userDto);
            if(temp!=null){
                this.userDao.update(userDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(UserDto userDto) throws ManagerException {
        try {
            UserDto temp = this.userDao.selectId(userDto);
            if(temp!=null) {
                this.userDao.delete(userDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
