package com.example.Reto1_Grupo3.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.security.configuration.JwtTokenUtil;
import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.security.model.UserDTO;
import com.example.Reto1_Grupo3.security.model.UserLoginRequest;
import com.example.Reto1_Grupo3.security.model.UserLoginResponse;
import com.example.Reto1_Grupo3.security.model.UserPostRequest;
import com.example.Reto1_Grupo3.security.model.UserPutRequest;
import com.example.Reto1_Grupo3.security.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<?> signIn(@RequestBody @Valid UserPostRequest userPostRequest) throws UserNotCreatedException {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(userPostRequest.getPassword());
		
		userPostRequest.setPassword(password);
		return new ResponseEntity<Integer>(userService.registerUser(convertPostRequestToDTO(userPostRequest)), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest userLoginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userLoginRequest.getLogin(), userLoginRequest.getPassword())
			);
			UserDAO userDAO = (UserDAO) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(userDAO);
			UserLoginResponse response = new UserLoginResponse(userLoginRequest.getLogin(),accessToken,userDAO.getId());
			return ResponseEntity.ok().body(response);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
			
	}
	
	@PutMapping("/auth/changePassword")
	public ResponseEntity<?> changePassword(@Valid @RequestBody UserPutRequest userPutRequest,Authentication authentication) throws UserNotFoundException,UserNotModifiedException {
		try {
			UserDAO userDAO = (UserDAO) authentication.getPrincipal();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			UserDTO userDTO = userService.findUserById(userDAO.getId());
			if(passwordEncoder.matches(userPutRequest.getOldPassword(),userDTO.getPassword())) {
				userDAO.setPassword(passwordEncoder.encode(userPutRequest.getPassword()));
				userService.changePassword(userDAO);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
			
	}
	
	@PostMapping("/auth/checkEmail")
	public ResponseEntity<?> checkEmail(@RequestBody UserPostRequest userPostRequest) {
		try {
			System.out.println("Controller - Email: " + userPostRequest.getEmail().toString());
			userService.checkEmail(userPostRequest.getEmail());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
			
	}
	
	@PostMapping("/auth/checkLogin")
	public ResponseEntity<?> checkLogin(@RequestBody UserPostRequest userPostRequest) {
		try {
			System.out.println("Controller - Login: " + userPostRequest.getLogin().toString());
			userService.checkLogin(userPostRequest.getLogin());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
			
	}
	
	private UserDTO convertPostRequestToDTO(UserPostRequest userPostRequest) {
		return new UserDTO(
				userPostRequest.getId(),
				userPostRequest.getName(),
				userPostRequest.getSurname(),
				userPostRequest.getLogin(),
				userPostRequest.getEmail(),
				userPostRequest.getPassword()
				);
	}

	
}
