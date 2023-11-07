package com.example.Reto1_Grupo3.security.repository;

import java.util.List;
import java.util.Optional;

import com.example.Reto1_Grupo3.security.exceptions.UserEmptyListException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;

public interface UserRepository {

	List<UserDAO> findAll() throws UserEmptyListException;
	int registerUser(UserDAO userDAO) throws UserNotCreatedException;
	UserDAO findByEmail(String email) throws UserNotFoundException;
	Optional<UserDAO> findByLogin(String login);
	int changePassword(UserDAO userDAO) throws UserNotModifiedException;
	
}
