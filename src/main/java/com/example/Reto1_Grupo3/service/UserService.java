package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.exceptions.users.UserEmptyListException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotFoundException;
import com.example.Reto1_Grupo3.model.user.UserDTO;

public interface UserService {

	List<UserDTO> findAll() throws UserEmptyListException;
	int registerUser(UserDTO userDTO) throws UserNotCreatedException;
	boolean loginUser(UserDTO userDTO) throws UserNotFoundException;
	int changePassword(UserDTO userDTO) throws UserNotFoundException;
}
