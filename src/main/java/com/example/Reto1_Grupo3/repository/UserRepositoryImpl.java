package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.exceptions.users.UserEmptyListException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotFoundException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotModifiedException;
import com.example.Reto1_Grupo3.model.user.UserDAO;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserDAO> findAll() throws UserEmptyListException {
		try {
			return jdbcTemplate.query(
					"SELECT * FROM users",
					BeanPropertyRowMapper.newInstance(UserDAO.class)
					);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new UserEmptyListException("User list is empty in Repository");
		}
	}
	
	@Override
	public int registerUser(UserDAO userDAO) throws UserNotCreatedException{
		try {
			return jdbcTemplate.update(
					"INSERT INTO users (name, surname,login, email, password) VALUES(?,?,?,?,?)",
					new Object[] {userDAO.getName(),userDAO.getSurname(),userDAO.getLogin(),userDAO.getEmail(),userDAO.getPassword()}
					);
		} catch (DuplicateKeyException e) {
			throw new UserNotCreatedException("User email already in use in Repository");
		}
	}

	
	public UserDAO findByEmail(String email) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE email = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					email);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("User Not Found in Repository");
		}		
	}
	
	public UserDAO findByLogin(String login) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE email = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					login);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("User Not Found in Repository");
		}		
	}
	
	public int changePassword(UserDAO userDAO) throws UserNotModifiedException {
		try {
			return jdbcTemplate.update(
					"UPDATE users SET password = ? WHERE id = ?",
					new Object[] {userDAO.getPassword(),userDAO.getId()}
					);
		} catch (DataAccessException e) {
			throw new UserNotModifiedException("User not modified in Repository");
		}
		
	}

	

}
