package com.example.Reto1_Grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Reto1_Grupo3.model.user.UserDTO;
import com.example.Reto1_Grupo3.model.user.UserGetResponse;
import com.example.Reto1_Grupo3.model.user.UserPostRequest;
import com.example.Reto1_Grupo3.service.UserService;


@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<UserGetResponse> findAllUsers() {
		List<UserDTO> userDTO = userService.findAll();
		List<UserGetResponse> userGetResponse = new ArrayList<UserGetResponse>();
		for (UserDTO user : userDTO) {
			userGetResponse.add(convertDTOtoResponse(user));
		}
		return userGetResponse;
	}
	
	
	@PostMapping("/register")
	public int register(@RequestBody UserPostRequest userPostRequest) {
		return userService.registerUser(convertRequestToDTO(userPostRequest));
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserPostRequest userPostRequest) {
			return userService.loginUser(convertRequestToDTO(userPostRequest));
	}
	
	@PutMapping("/changePassword")
	public int changePassword(@RequestBody UserPostRequest userPostRequest) {
			return userService.changePassword(convertRequestToDTO(userPostRequest));
	}

	
	
	private UserDTO convertRequestToDTO(UserPostRequest userPostRequest) {
		UserDTO userDTO = new UserDTO(
				userPostRequest.getId(),
				userPostRequest.getName(),
				userPostRequest.getSurname(),
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
				userDTO.getEmail(),
				userDTO.getPassword()
				);	
	}

	
}
