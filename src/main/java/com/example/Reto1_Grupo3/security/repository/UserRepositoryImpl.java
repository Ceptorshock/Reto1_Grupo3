package com.example.Reto1_Grupo3.security.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserDAO findUserById(Integer id) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE id = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					id);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new UserNotFoundException("User not in Repository");
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
	
	public Optional<UserDAO> findByLogin(String login) {
		try {
			System.out.println("Repository - Login: " + login);
			UserDAO userDAO = jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE login = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					login);
			System.out.println("Respository - userDAO: " + userDAO.getLogin() + " " + userDAO.getPassword());
			return Optional.of(userDAO);
		} catch (EmptyResultDataAccessException e){
			e.printStackTrace();
			return Optional.empty();
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
	
	public UserDAO checkIfEmailExists(String email) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE email = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					email);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("Email not found in Repository");	
		}		
	}
	public UserDAO checkIfLoginExists(String login) throws UserNotFoundException {
		try {
			System.out.println("Respository - userDAO: " + login);
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE login = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					login);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("Login not found in Repository");	
		}		
	}


}
