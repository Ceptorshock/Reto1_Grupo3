package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.user.UserDAO;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserDAO> findAll() {
		return jdbcTemplate.query(
				"SELECT * FROM users",
				BeanPropertyRowMapper.newInstance(UserDAO.class)
				);
	}
	
	@Override
	public int registerUser(UserDAO userDAO) {
		return jdbcTemplate.update(
				"INSERT INTO users (name, surname, email, password) VALUES(?,?,?,?)",
				new Object[] {userDAO.getName(),userDAO.getSurname(),userDAO.getEmail(),userDAO.getPassword()}
				);
	}

	
	public UserDAO findByEmail(String email) {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM users WHERE email = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					email);
	}
	
	public int changePassword(UserDAO userDAO) {
		return jdbcTemplate.update(
				"UPDATE users SET password = ? WHERE id = ?",
				new Object[] {userDAO.getPassword(),userDAO.getId()}
				);
	}

	

}
