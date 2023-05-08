package com.backend.store.dao;

import com.backend.store.dto.CategoryDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.CategoryMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate jdbcTemplate;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_category, " +
                        "name, " +
                        "description " +
                        "FROM categories " +
                        "ORDER BY id_category ASC;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public CategoryDto selectId(CategoryDto categoryDto) throws DaoException {
        String SQL = "SELECT id_category, " +
                "name, " +
                "description " +
                "FROM categories " +
                "WHERE id_category=?;";
        CategoryDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new CategoryMapper(), categoryDto.getIdCategory());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(CategoryDto categoryDto) throws DaoException {
        String SQL = "INSERT INTO categories(name, " +
                        "description) " +
                        "VALUES (?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    categoryDto.getName(),
                    categoryDto.getDescription()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(CategoryDto categoryDto) throws DaoException {
        String SQL = "UPDATE categories SET name=?, " +
                "description=? " +
                "WHERE id_category=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    categoryDto.getName(),
                    categoryDto.getDescription(),
                    categoryDto.getIdCategory()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(CategoryDto categoryDto) throws DaoException {
        String SQL = "DELETE FROM categories WHERE id_category=?;";
        try {
            this.jdbcTemplate.update(SQL, categoryDto.getIdCategory());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
