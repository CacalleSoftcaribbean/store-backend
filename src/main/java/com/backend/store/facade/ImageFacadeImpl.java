package com.backend.store.facade;

import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.FacadeException;
import com.backend.store.exceptions.ManagerException;
import com.backend.store.manager.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class ImageFacadeImpl implements ImageFacade {
    @Autowired
    private ImageManager imageManager;

    @Override
    public List<Map<String, Object>> selectAll() throws FacadeException {
        try {
            return this.imageManager.selectAll();
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public ImageDto selectId(ImageDto imageDto) throws FacadeException {
        try {
            return this.imageManager.selectId(imageDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void insert(ImageDto imageDto) throws FacadeException {
        try {
            this.imageManager.insert(imageDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void update(ImageDto imageDto) throws FacadeException {
        try {
            this.imageManager.update(imageDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(ImageDto imageDto) throws FacadeException {
        try {
            this.imageManager.delete(imageDto);
        } catch (ManagerException me) {
            throw new FacadeException(me);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }
}
