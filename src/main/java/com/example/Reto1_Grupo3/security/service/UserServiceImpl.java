package com.example.Reto1_Grupo3.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.security.model.UserDTO;
import com.example.Reto1_Grupo3.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO findUserById(Integer id) throws UserNotFoundException {
		UserDAO userDAO = userRepository.findUserById(id);
		return convertDAOtoDTO(userDAO);
	}
	

	@Override
	public int registerUser(UserDTO userDTO) throws UserNotCreatedException {
		return userRepository.registerUser(convertDTOtoDAO(userDTO));
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Service - Login: " + username);
		return userRepository.findByLogin(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User " + username + " not found"));
	}
	
	@Override
	public int changePassword(UserDAO userDAO) throws UserNotModifiedException {
		return userRepository.changePassword(userDAO);
	}
	
	@Override
	public UserDTO checkEmail(String email) throws UserNotFoundException {
		return convertDAOtoDTO(userRepository.checkIfEmailExists(email));
	}
	@Override
	public UserDTO checkLogin(String login) throws UserNotFoundException {
		System.out.println("Service - userDAO: " + login);
		return convertDAOtoDTO(userRepository.checkIfLoginExists(login));
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
