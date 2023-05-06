package com.backend.store.dao;

import com.backend.store.dto.AddressDto;
import com.backend.store.dto.UserDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.AddressMapper;
import com.backend.store.mapper.UserMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements  UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT id_user, " +
                        "person_id, " +
                        "username, " +
                        "password, " +
                        "token " +
                        "FROM users;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public UserDto selectId(UserDto userDto) throws DaoException {
        String SQL = "SELECT id_user, " +
                "person_id, " +
                "username, " +
                "password, " +
                "token " +
                "FROM users " +
                "WHERE id_user=?;";
        UserDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new UserMapper(), userDto.getIdUser());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(UserDto userDto) throws DaoException {
        String SQL = "INSERT INTO users(person_id, " +
                        "username, " +
                        "password, " +
                        "token) " +
                        "VALUES (?, ?, ?, ?);";
        try {
            this.jdbcTemplate.update(SQL,
                    userDto.getPersonDto().getIdPerson(),
                    userDto.getUsername(),
                    userDto.getPassword(),
                    userDto.getToken()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(UserDto userDto) throws DaoException {
        String SQL = "UPDATE users SET person_id=?, " +
                        "username=?, " +
                        "password=?, " +
                        "token=? " +
                        "WHERE id_user=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    userDto.getPersonDto().getIdPerson(),
                    userDto.getUsername(),
                    userDto.getPassword(),
                    userDto.getToken(),
                    userDto.getIdUser()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(UserDto userDto) throws DaoException {
        String SQL = "DELETE FROM users WHERE id_user=?;";
        try {
            this.jdbcTemplate.update(SQL, userDto.getIdUser());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
