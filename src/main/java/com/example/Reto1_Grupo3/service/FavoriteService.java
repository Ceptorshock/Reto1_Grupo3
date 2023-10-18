package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDTO;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;

public interface FavoriteService {

	List<FavoriteDTO> findAll(Integer id);
	Integer addFavorite(FavoritePostRequest favorite);
	Integer deleteFavorite(Integer id);
}
