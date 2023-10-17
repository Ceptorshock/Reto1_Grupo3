package com.example.Reto1_Grupo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.user.UserDAO;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDAO findByEmail(String email) {
			return jdbcTemplate.queryForObject(
					"SELECT * FROM employees WHERE id = ?",
					BeanPropertyRowMapper.newInstance(UserDAO.class),
					email);
	}

}
