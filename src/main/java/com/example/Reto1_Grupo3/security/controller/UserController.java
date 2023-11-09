package com.example.Reto1_Grupo3.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.security.configuration.JwtTokenUtil;
import com.example.Reto1_Grupo3.security.exceptions.UserEmptyListException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotCreatedException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotFoundException;
import com.example.Reto1_Grupo3.security.exceptions.UserNotModifiedException;
import com.example.Reto1_Grupo3.security.model.RegistrationCheckRequest;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.security.model.UserDTO;
import com.example.Reto1_Grupo3.security.model.UserGetResponse;
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
	
	
//	@PostMapping("/register")
//	public ResponseEntity<?> register(@Valid @RequestBody UserPostRequest userPostRequest) throws UserNotCreatedException {
//		try {
//			userService.registerUser(convertPostRequestToDTO(userPostRequest));
//			return new ResponseEntity<>(HttpStatus.CREATED);
//		} catch (UserNotCreatedException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
//		}
//	}
	
	@PostMapping("/auth/register")
	public ResponseEntity<?> signIn(@RequestBody @Valid UserPostRequest userPostRequest) throws UserNotCreatedException {
		// TODO solo esta creado en el caso de que funcione. Si no es posible que de 500 o 401.
		// aqui hacer lo que sea preciso

		// vamos a cifrar la contrasenia aqui, ya que no queremos andar dando vueltas con la contraseña sin encriptar si no es preciso
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(userPostRequest.getPassword());
		
		// creamos el usuario en DB
		userPostRequest.setPassword(password);
		//UserDTO userDTO = new UserDTO(userPostRequest.getLogin(), password);
		return new ResponseEntity<Integer>(userService.registerUser(convertPostRequestToDTO(userPostRequest)), HttpStatus.CREATED);
	}
	
	
	// utilizamos el /me por que vamos a coger el nuestro, el que estamos logueado...
	@GetMapping("/auth/me")
	public ResponseEntity<?> getUserInfo(Authentication authentication) {
		// aqui podemos castearlo a UserDetails o User. El UserDetails es una interfaz, 
		// si lo casteamos a la interfaz no podremos sacar campos como la ID del usuario
		UserDAO userDetails = (UserDAO) authentication.getPrincipal();
		
		// IMPORTANTE: por lo tanto, la ID del usuario no tiene que ir como parametro en la peticion del usuario
		
		// aqui podriamos devolver datos del usuario. quizá no sea lo que queremos devolver o no lo querramos devolver
		// es un ejemplo por que con userDetails.getId() tendríamos la ID del usuario sin que la pase por parametro
		// necesario en algunos servicios: si quiero devolver una lista o elemento privado del usuario, no voy a querer
		// que el usuario mande su ID por parametro. Ya que es trampeable.
		// de ahi que sea "/me" en el ejemplo 
		
		return ResponseEntity.ok().body(userDetails);
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
	public ResponseEntity<?> changePassword(@Valid @RequestBody UserPutRequest userPutRequest) throws UserNotFoundException,UserNotModifiedException {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userPutRequest.getLogin(), userPutRequest.getOldPassword())
			);
			UserDAO userDAO = (UserDAO) authentication.getPrincipal();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			userDAO.setPassword(passwordEncoder.encode(userPutRequest.getPassword()));
			userService.changePassword(userDAO);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
	
//	private UserDTO convertLoginRequestToDTO(UserLoginRequest userLoginRequest) {
//		return new UserDTO(
//				userLoginRequest.getLogin(),
//				userLoginRequest.getPassword()
//				);
//	}
//	
//	private UserDTO convertPutRequestToDTO(UserPutRequest userPutRequest) {
//		return new UserDTO(
//				userPutRequest.getLogin(),
//				userPutRequest.getPassword(),
//				userPutRequest.getOldPassword()
//				);
//	}



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
