package com.example.Reto1_Grupo3.exceptions.song;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Song doesn´t exist.")
public class SongNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public SongNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
