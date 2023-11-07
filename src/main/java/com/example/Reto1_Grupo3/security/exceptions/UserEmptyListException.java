package com.example.Reto1_Grupo3.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "User is empty.")
public class UserEmptyListException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public UserEmptyListException(String errorMessage) {
		super(errorMessage);
	}
}
