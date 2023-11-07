package com.example.Reto1_Grupo3.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User can't be created.")
public class UserNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserNotCreatedException(String errorMessage) {
		super(errorMessage);
	}
}