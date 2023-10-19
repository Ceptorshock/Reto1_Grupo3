package com.example.Reto1_Grupo3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto1_Grupo3.exceptions.users.UserEmptyListException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotFoundException;
import com.example.Reto1_Grupo3.model.user.UserDAO;
import com.example.Reto1_Grupo3.model.user.UserDTO;
import com.example.Reto1_Grupo3.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserDTO> findAll() throws UserEmptyListException {
		List<UserDAO> userDAO = userRepository.findAll();
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		for (UserDAO user : userDAO){
			userDTO.add(convertDAOtoDTO(user));
		}
		return userDTO;
	}
	

	@Override
	public int registerUser(UserDTO userDTO) throws UserNotCreatedException {
		return userRepository.registerUser(convertDTOtoDAO(userDTO));
	}
	
	@Override
	public boolean loginUser(UserDTO userDTO) throws UserNotFoundException {
		//UserDTO user = convertDAOtoDTO(userRepository.findByEmail(userDTO.getEmail()));
		UserDTO user = convertDAOtoDTO(userRepository.findByLogin(userDTO.getEmail()));
		System.out.println("BD:" + user.getPassword() + "/// Post:" + userDTO.getPassword()+"///");
		if(user.getPassword().equals(userDTO.getPassword()))
		{
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public int changePassword(UserDTO userDTO) throws UserNotFoundException {
		UserDTO user = convertDAOtoDTO(userRepository.findByEmail(userDTO.getEmail()));
		System.out.println("BD:" + user.getPassword() + "/// PUT:" + userDTO.getOldPassword()+"///");
		if (user.getPassword().equals(userDTO.getOldPassword()) ) {
			user.setPassword(userDTO.getPassword());
			return userRepository.changePassword(convertDTOtoDAO(user));
		} else {
			return 0;
		}
	}

	private UserDTO convertDAOtoDTO(UserDAO userDAO) {
		return new UserDTO(
				userDAO.getId(),
				userDAO.getName(),
				userDAO.getSurname(),
				userDAO.getLogin(),
				userDAO.getEmail(),
				userDAO.getPassword()
				);	
	}
	
	private UserDAO convertDTOtoDAO(UserDTO userDTO) {
		return new UserDAO(
				userDTO.getId(),
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getLogin(),
				userDTO.getEmail(),
				userDTO.getPassword()
				);	
	}



}
