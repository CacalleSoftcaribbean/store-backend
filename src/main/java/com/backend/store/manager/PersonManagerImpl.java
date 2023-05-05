package com.backend.store.manager;

import com.backend.store.dao.PersonDao;
import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class PersonManagerImpl implements PersonManager {

    @Autowired
    private PersonDao personDao;
    public PersonManagerImpl() {
    }
    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.personDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public PersonDto selectId(PersonDto personDto) throws ManagerException {
        try {
            return this.personDao.selectId(personDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(PersonDto personDto) throws ManagerException {
        try {
            PersonDto temp = this.personDao.selectId(personDto);
            if(temp==null){
                this.personDao.insert(personDto);
            }else{
                this.personDao.update(personDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(PersonDto personDto) throws ManagerException {
        try {
            PersonDto temp = this.personDao.selectId(personDto);
            if(temp!=null){
                this.personDao.update(personDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(PersonDto personDto) throws ManagerException {
        try {
            PersonDto temp = this.personDao.selectId(personDto);
            if(temp!=null) {
                this.personDao.delete(personDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }
}
