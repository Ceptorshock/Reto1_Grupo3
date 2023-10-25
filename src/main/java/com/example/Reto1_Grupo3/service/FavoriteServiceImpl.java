package com.example.Reto1_Grupo3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoriteDAO;
import com.example.Reto1_Grupo3.model.favorite.FavoriteDTO;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Autowired
	FavoriteRepository favoriteRepository;

	@Override
	public Integer deleteFavorite(Integer id_song, Integer id_user) throws FavoriteNotDeletedException {
		return favoriteRepository.deleteFavorite(id_song, id_user); 
	}

	@Override
	public Integer addFavorite(FavoritePostRequest favorite) throws FavoriteNotCreatedException {
		return favoriteRepository.addFavorite(favorite);	
	}
	
	private List<FavoriteDTO> fromDAOToDTO(List<FavoriteDAO> listFavoriteDAO) {
			
		List<FavoriteDTO> listFavoriteDTO = new ArrayList<FavoriteDTO>();
		
		for (FavoriteDAO favoriteDAO : listFavoriteDAO) {
			listFavoriteDTO.add(
					new FavoriteDTO(
							favoriteDAO.getId(),
							favoriteDAO.getId_song(),
							favoriteDAO.getId_user()));
		}
		return listFavoriteDTO;
	}

}
