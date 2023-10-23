package com.example.Reto1_Grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.service.FavoriteService;

import jakarta.validation.Valid;
@RestController
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	
	@DeleteMapping("/fav/{id}")
	public ResponseEntity<Integer> deleteFavorite(@PathVariable("id") Integer id) throws FavoriteNotDeletedException {
		try {
			return new ResponseEntity<>(favoriteService.deleteFavorite(id), HttpStatus.OK);
		} catch (FavoriteNotDeletedException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage(), e);
		}
	}
	
	
	@PostMapping("/fav")
	public ResponseEntity<Integer> createFavorite(@Valid @RequestBody FavoritePostRequest favorite)  throws FavoriteNotDeletedException {
		try {
			return new ResponseEntity<Integer>(favoriteService.addFavorite(favorite), HttpStatus.CREATED);
		} catch (FavoriteNotCreatedException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	
	}
	

}
