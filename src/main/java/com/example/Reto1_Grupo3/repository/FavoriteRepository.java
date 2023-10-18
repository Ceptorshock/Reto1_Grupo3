package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDAO;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;

public interface FavoriteRepository {

	List<FavoriteDAO> findAll(Integer id);
	Integer addFavorite(FavoritePostRequest favorite);
	Integer deleteFavorite(Integer id);
	boolean findFavorite(FavoritePostRequest favorite);
	
}
