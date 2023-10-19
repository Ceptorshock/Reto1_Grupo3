package com.example.Reto1_Grupo3.repository;


import com.example.Reto1_Grupo3.exceptions.users.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.users.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;

public interface FavoriteRepository {

	Integer addFavorite(FavoritePostRequest favorite) throws FavoriteNotCreatedException;
	Integer deleteFavorite(Integer id) throws FavoriteNotDeletedException;
	
}
