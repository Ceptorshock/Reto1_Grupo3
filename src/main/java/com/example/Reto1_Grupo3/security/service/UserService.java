package com.example.Reto1_Grupo3.security.service;

import java.util.List;

import com.example.Reto1_Grupo3.security.exceptions.UserEmptyListException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.security.model.UserDTO;

public interface UserService {

	List<UserDTO> findAll() throws UserEmptyListException;
	int registerUser(UserDTO userDTO) throws UserNotCreatedException;
	int changePassword(UserDAO userDAO) throws UserNotModifiedException;
}
