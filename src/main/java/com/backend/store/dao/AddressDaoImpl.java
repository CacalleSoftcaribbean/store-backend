package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class AddressDaoImpl implements AddressDao {

    private JdbcTemplate jdbcTemplate;

    public AddressDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_address, " +
                        "person_id, " +
                        "address, " +
                        "city, " +
                        "country, " +
                        "postal_code " +
                        "FROM addresses;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public AddressDto selectId(AddressDto addressDto) throws DaoException {
        String SQL = "SELECT id_address, " +
                "person_id, " +
                "address, " +
                "city, " +
                "country, " +
                "postal_code " +
                "FROM addresses " +
                "WHERE id_address=?;";
        AddressDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new AddressMapper(), addressDto.getIdAddress());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(AddressDto addressDto) throws DaoException {
        String SQL = "INSERT INTO addresses(person_id, " +
                        "address, " +
                        "city, " +
                        "country, " +
                        "postal_code) " +
                        "VALUES (?, ?, ?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    addressDto.getPersonDto().getIdPerson(),
                    addressDto.getAddress(),
                    addressDto.getCity(),
                    addressDto.getCountry(),
                    addressDto.getPostalCode()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(AddressDto addressDto) throws DaoException {
        String SQL = "UPDATE addresses SET " +
                        "person_id=?, " +
                        "address=?, " +
                        "city=?, " +
                        "country=?, " +
                        "postal_code=? " +
                        "WHERE id_address=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    addressDto.getPersonDto().getIdPerson(),
                    addressDto.getAddress(),
                    addressDto.getCity(),
                    addressDto.getCountry(),
                    addressDto.getPostalCode(),
                    addressDto.getIdAddress()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(AddressDto addressDto) throws DaoException {
        String SQL = "DELETE FROM addresses WHERE id_address=?";
        try {
            this.jdbcTemplate.update(SQL, addressDto.getIdAddress());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
