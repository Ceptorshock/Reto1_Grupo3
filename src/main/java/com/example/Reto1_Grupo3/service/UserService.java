package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.user.UserDTO;

public interface UserService {

	List<UserDTO> findAll();
	int registerUser(UserDTO userDTO);
	boolean loginUser(UserDTO userDTO);
	int changePassword(UserDTO userDTO);
}
