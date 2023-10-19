package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.exceptions.users.UserEmptyListException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotFoundException;
import com.example.Reto1_Grupo3.model.user.UserDAO;

public interface UserRepository {

	List<UserDAO> findAll() throws UserEmptyListException;
	int registerUser(UserDAO userDAO) throws UserNotCreatedException;
	UserDAO findByEmail(String email) throws UserNotFoundException;
	UserDAO findByLogin(String login) throws UserNotFoundException;
	int changePassword(UserDAO userDAO);
	
}
