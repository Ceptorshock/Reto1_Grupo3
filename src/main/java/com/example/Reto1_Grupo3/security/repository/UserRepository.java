package com.example.Reto1_Grupo3.security.repository;

import java.util.Optional;

import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;

public interface UserRepository {

	UserDAO findUserById(Integer id) throws UserNotFoundException;
	int registerUser(UserDAO userDAO) throws UserNotCreatedException;
	UserDAO findByEmail(String email) throws UserNotFoundException;
	Optional<UserDAO> findByLogin(String login);
	int changePassword(UserDAO userDAO) throws UserNotModifiedException;
	UserDAO checkIfEmailExists(String email) throws UserNotFoundException;
	UserDAO checkIfLoginExists(String login) throws UserNotFoundException;
	
}
