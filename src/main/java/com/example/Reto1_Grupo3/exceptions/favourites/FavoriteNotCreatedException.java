package com.example.Reto1_Grupo3.exceptions.favourites;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User can't be created.")
public class FavoriteNotCreatedException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public FavoriteNotCreatedException(String errorMessage) {
		super(errorMessage);
	}
}