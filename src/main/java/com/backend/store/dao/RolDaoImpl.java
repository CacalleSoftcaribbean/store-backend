package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.dto.RolDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import com.backend.store.mapper.RolMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RolDaoImpl implements RolDao {
    private JdbcTemplate jdbcTemplate;

    public RolDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_rol, " +
                        "name, " +
                        "description, " +
                        "status " +
                        "FROM roles;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public RolDto selectId(RolDto rolDto) throws DaoException {
        String SQL = "SELECT id_rol, " +
                        "name, " +
                        "description, " +
                        "status " +
                        "FROM roles " +
                        "WHERE id_rol=?;";
        RolDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new RolMapper(), rolDto.getIdRol());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(RolDto rolDto) throws DaoException {
        String SQL = "INSERT INTO roles(name, " +
                        "description, " +
                        "status) " +
                        "VALUES (?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    rolDto.getName(),
                    rolDto.getDescription(),
                    rolDto.getStatus()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(RolDto rolDto) throws DaoException {
        String SQL = "UPDATE roles SET " +
                        "name=?, " +
                        "description=?, " +
                        "status=? " +
                        "WHERE id_rol=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    rolDto.getName(),
                    rolDto.getDescription(),
                    rolDto.getStatus(),
                    rolDto.getIdRol()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(RolDto rolDto) throws DaoException {
        String SQL = "DELETE FROM roles WHERE id_rol=?;";
        try {
            this.jdbcTemplate.update(SQL, rolDto.getIdRol());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
