package com.backend.store.dao;

import com.backend.store.date.UtilDate;
import com.backend.store.dto.PersonDto;
import com.backend.store.exceptions.DaoException;
import com.backend.store.mapper.PersonMapper;
import com.backend.store.util.DaoUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDaoImpl implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> selectAll() throws DaoException {
        String SQL = "SELECT p.id_person, " +
                        "p.rol_id, " +
                        "p.first_name, " +
                        "p.second_name, " +
                        "p.first_lastname, " +
                        "p.second_lastname, " +
                        "p.phone, " +
                        "p.email, " +
                        "p.date_birth, " +
                        "r.name	" +
                        "FROM persons AS p " +
                        "INNER JOIN roles AS r " +
                        "ON r.id_rol = p.rol_id " +
                        "ORDER BY p.id_person ASC;";
        try {
            return this.jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public PersonDto selectId(PersonDto personDto) throws DaoException {
        String SQL = "SELECT  rol_id, " +
                        "id_person, " +
                        "first_name, " +
                        "second_name, " +
                        "first_lastname, " +
                        "second_lastname, " +
                        "phone, " +
                        "email, " +
                        "date_birth " +
                        "FROM persons " +
                        "WHERE id_person=?;";
        PersonDto result = null;
        try {
            result = this.jdbcTemplate.queryForObject(SQL, new PersonMapper(), personDto.getIdPerson());
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public PersonDto insert(PersonDto personDto) throws DaoException {
        String SQL = "INSERT INTO persons(rol_id, " +
                        "first_name, " +
                        "second_name, " +
                        "first_lastname, " +
                        "second_lastname, " +
                        "phone, " +
                        "email, " +
                        "date_birth) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, new String[]{ "id_person" });
            DaoUtil.setPrepareStatement(ps,
                    new Object[] {
                            personDto.getRolDto().getIdRol(),
                            personDto.getFirstName(),
                            personDto.getSecondName(),
                            personDto.getFirstLastname(),
                            personDto.getSecondLastname(),
                            personDto.getPhone(),
                            personDto.getEmail(),
                            UtilDate.toSqlDate(personDto.getDateBirth())
                    }
            );
            return ps;
        }, keyHolder);
        personDto.setIdPerson(keyHolder.getKey().intValue());
        return personDto;
    }

    @Override
    public void update(PersonDto personDto) throws DaoException {
        String SQL = "UPDATE persons SET rol_id=? " +
                        "first_name=?, " +
                        "second_name=?, " +
                        "first_lastname=?, " +
                        "second_lastname=?, " +
                        "phone=?, " +
                        "email=?, " +
                        "date_birth=? " +
                        "WHERE id_person=?;";
        try {
            this.jdbcTemplate.update(SQL,
                    personDto.getRolDto().getIdRol(),
                    personDto.getFirstName(),
                    personDto.getSecondName(),
                    personDto.getFirstLastname(),
                    personDto.getSecondLastname(),
                    personDto.getPhone(),
                    personDto.getEmail(),
                    UtilDate.toSqlDate(personDto.getDateBirth()),
                    personDto.getIdPerson()
            );
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(PersonDto personDto) throws DaoException {
        String SQL = "DELETE FROM persons WHERE id_person=?;";
        try {
            this.jdbcTemplate.update(SQL, personDto.getIdPerson());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
