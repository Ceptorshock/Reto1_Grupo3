package com.example.Reto1_Grupo3.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;

public interface FavoriteService {

	Integer addFavorite(FavoritePostRequest favorite)throws FavoriteNotCreatedException;
	Integer deleteFavorite(Integer id_user, Integer id_song) throws FavoriteNotDeletedException;
}
