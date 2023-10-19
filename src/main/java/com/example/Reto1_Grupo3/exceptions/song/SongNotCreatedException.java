package com.example.Reto1_Grupo3.exceptions.song;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Song can't be created.")
public class SongNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SongNotCreatedException(String errorMessage) {
		super(errorMessage);
	}
}
