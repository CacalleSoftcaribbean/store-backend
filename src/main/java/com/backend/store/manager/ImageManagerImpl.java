package com.backend.store.manager;

import com.backend.store.dao.ImageDao;
import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ImageManagerImpl implements ImageManager {
    @Autowired
    private ImageDao imageDao;

    public ImageManagerImpl() {
    }

    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.imageDao.selectAll();
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public ImageDto selectId(ImageDto imageDto) throws ManagerException {
        try {
            return this.imageDao.selectId(imageDto);
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void insert(ImageDto imageDto) throws ManagerException {
        try {
            ImageDto temp = this.imageDao.selectId(imageDto);
            if(temp==null){
                this.imageDao.insert(imageDto);
            }else{
                this.imageDao.update(imageDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void update(ImageDto imageDto) throws ManagerException {
        try {
            ImageDto temp = this.imageDao.selectId(imageDto);
            if(temp!=null){
                this.imageDao.update(imageDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(ImageDto imageDto) throws ManagerException {
        try {
            ImageDto temp = this.imageDao.selectId(imageDto);
            if(temp!=null) {
                this.imageDao.delete(imageDto);
            }
        } catch (DaoException de) {
            throw new ManagerException(de);
        } catch (Exception e) {
            throw new ManagerException(e);
        }    }
}
