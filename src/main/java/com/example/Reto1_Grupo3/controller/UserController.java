package com.example.Reto1_Grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.model.user.UserDTO;
import com.example.Reto1_Grupo3.model.user.UserPostRequest;
import com.example.Reto1_Grupo3.service.UserService;


@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserPostRequest userPostRequest) {
			return userService.loginUser(convertRequestToDTO(userPostRequest));
	}

	
	
	private UserDTO convertRequestToDTO(UserPostRequest userPostRequest) {
		return new UserDTO(
				userPostRequest.getId(),
				userPostRequest.getName(),
				userPostRequest.getSurname(),
				userPostRequest.getEmail(),
				userPostRequest.getPassword()
				);	
	}
	
	private UserPostRequest convertDTOtoResponse(UserDTO userDTO) {
		return new UserPostRequest(
				userDTO.getId(),
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getPassword()
				);	
	}

	
}
