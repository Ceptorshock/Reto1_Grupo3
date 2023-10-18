package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.model.user.UserDAO;

public interface UserRepository {

	List<UserDAO> findAll();
	int registerUser(UserDAO userDAO);
	UserDAO findByEmail(String email);
	int changePassword(UserDAO userDAO);
	
}
