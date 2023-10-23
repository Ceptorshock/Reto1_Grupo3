package com.example.Reto1_Grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.exceptions.users.UserEmptyListException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotFoundException;
import com.example.Reto1_Grupo3.exceptions.users.UserNotModifiedException;
import com.example.Reto1_Grupo3.model.user.UserDTO;
import com.example.Reto1_Grupo3.model.user.UserGetResponse;
import com.example.Reto1_Grupo3.model.user.UserPostRequest;
import com.example.Reto1_Grupo3.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserGetResponse>> findAllUsers() throws UserEmptyListException {
		try {
			List<UserDTO> userDTO = userService.findAll();
			List<UserGetResponse> userGetResponse = new ArrayList<UserGetResponse>();
			for (UserDTO user : userDTO) {
				userGetResponse.add(convertDTOtoResponse(user));
			}
			return new ResponseEntity<>(userGetResponse,HttpStatus.ACCEPTED);
		} catch (UserEmptyListException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage(),e);
		}
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserPostRequest userPostRequest) throws UserNotCreatedException {
		try {
			userService.registerUser(convertRequestToDTO(userPostRequest));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (UserNotCreatedException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserPostRequest userPostRequest) throws UserNotFoundException {
		try {
			userService.loginUser(convertRequestToDTO(userPostRequest));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
			
	}
	
	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@Valid @RequestBody UserPostRequest userPostRequest) throws UserNotFoundException,UserNotModifiedException {
		try {
			userService.changePassword(convertRequestToDTO(userPostRequest));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (UserNotFoundException | UserNotModifiedException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
			
	}

	
	
	private UserDTO convertRequestToDTO(UserPostRequest userPostRequest) {
		UserDTO userDTO = new UserDTO(
				userPostRequest.getId(),
				userPostRequest.getName(),
				userPostRequest.getSurname(),
				userPostRequest.getLogin(),
				userPostRequest.getEmail(),
				userPostRequest.getPassword());
		if (userPostRequest.getOldPassword() != null) {
			userDTO.setOldPassword(userPostRequest.getOldPassword());
		}
		return userDTO;
	}
	
	private UserGetResponse convertDTOtoResponse(UserDTO userDTO) {
		return new UserGetResponse(
				userDTO.getId(),
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getLogin(),
				userDTO.getEmail(),
				userDTO.getPassword()
				);	
	}

	
}
