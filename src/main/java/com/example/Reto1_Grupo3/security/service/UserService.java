package com.example.Reto1_Grupo3.security.service;

import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.security.model.UserDTO;

public interface UserService {

	UserDTO findUserById(Integer id) throws UserNotFoundException;
	int registerUser(UserDTO userDTO) throws UserNotCreatedException;
	int changePassword(UserDAO userDAO) throws UserNotModifiedException;
	UserDTO checkEmail(String email) throws UserNotFoundException;
	UserDTO checkLogin(String login) throws UserNotFoundException;
}
