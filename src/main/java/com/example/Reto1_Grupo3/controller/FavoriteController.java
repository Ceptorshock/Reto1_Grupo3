package com.example.Reto1_Grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.service.FavoriteService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("api")
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	
	@DeleteMapping("/fav/{id_user}/{id_song}")
	public ResponseEntity<Integer> deleteFavorite(@PathVariable("id_user") Integer id_song, @PathVariable("id_song") Integer id_user) throws FavoriteNotDeletedException {
		System.out.println(id_song + " "  + id_user);
		try {
			return new ResponseEntity<>(favoriteService.deleteFavorite(id_song, id_user), HttpStatus.OK);
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
