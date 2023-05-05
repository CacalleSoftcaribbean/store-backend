package com.backend.store.facade;

import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component
@Transactional
public class PersonFacadeImpl implements PersonFacade {
    @Autowired
    public PersonManager personManager;
    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.personManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public PersonDto selectId(PersonDto personDto) throws FacadeException {
        try {
            return this.personManager.selectId(personDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(PersonDto personDto) throws FacadeException {
        try {
            this.personManager.insert(personDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(PersonDto personDto) throws FacadeException {
        try {
            this.personManager.update(personDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(PersonDto personDto) throws FacadeException {
        try {
            this.personManager.delete(personDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
