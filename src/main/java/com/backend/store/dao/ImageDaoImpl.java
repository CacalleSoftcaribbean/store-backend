package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.dto.ImageDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import com.backend.store.mapper.ImageMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ImageDaoImpl implements  ImageDao {
    private JdbcTemplate jdbcTemplate;

    public ImageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_image, " +
                        "product_id, " +
                        "image " +
                        "FROM images;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ImageDto selectId(ImageDto imageDto) throws DaoException {
        String SQL = "SELECT id_image, " +
                        "product_id, " +
                        "image " +
                        "FROM images " +
                        "WHERE id_image=?;";
        ImageDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new ImageMapper(), imageDto.getIdImage());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(ImageDto imageDto) throws DaoException {
        String SQL = "INSERT INTO images(product_id, image) VALUES (?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    imageDto.getProductDto().getIdProduct(),
                    imageDto.getImage()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(ImageDto imageDto) throws DaoException {
        String SQL = "UPDATE images SET product_id=?, image=? WHERE id_image=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    imageDto.getProductDto().getIdProduct(),
                    imageDto.getImage(),
                    imageDto.getIdImage()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(ImageDto imageDto) throws DaoException {
        String SQL = "DELETE FROM images WHERE id_image=?;";
        try {
            this.jdbcTemplate.update(SQL, imageDto.getIdImage());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
