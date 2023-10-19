package com.example.Reto1_Grupo3.exceptions.song;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Song is empty.")
public class SongEmptyListException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public SongEmptyListException(String errorMessage) {
		super(errorMessage);
	}
}