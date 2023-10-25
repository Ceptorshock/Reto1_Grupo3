package com.example.Reto1_Grupo3.repository;


import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;

public interface FavoriteRepository {

	Integer addFavorite(FavoritePostRequest favorite) throws FavoriteNotCreatedException;
	Integer deleteFavorite(Integer id_song, Integer id_user) throws FavoriteNotDeletedException;
	
}
