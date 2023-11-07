package com.example.Reto1_Grupo3.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User not updated")
public class UserNotModifiedException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public UserNotModifiedException(String errorMessage) {
		super(errorMessage);
	}
}
