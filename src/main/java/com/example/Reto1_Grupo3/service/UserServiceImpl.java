package com.example.Reto1_Grupo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto1_Grupo3.model.user.UserDAO;
import com.example.Reto1_Grupo3.model.user.UserDTO;
import com.example.Reto1_Grupo3.model.user.UserPostRequest;
import com.example.Reto1_Grupo3.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean loginUser(UserDTO userDTO) {
		UserDTO user = convertDAOtoDTO(userRepository.findByEmail(userDTO.getEmail()));
		if(user.getPassword() == userDTO.getPassword())
		{
			return true;
		} else {
			return false;
		}
		
	}

	
	private UserDTO convertDAOtoDTO(UserDAO userDAO) {
		return new UserDTO(
				userDAO.getId(),
				userDAO.getName(),
				userDAO.getSurname(),
				userDAO.getEmail(),
				userDAO.getPassword()
				);	
	}
	
	private UserDAO convertDTOtoDAO(UserDTO userDTO) {
		return new UserDAO(
				userDTO.getId(),
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getPassword()
				);	
	}
}
