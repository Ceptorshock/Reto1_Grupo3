package com.example.Reto1_Grupo3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDAO;
import com.example.Reto1_Grupo3.model.favorite.FavoriteDTO;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Override
	public List<FavoriteDTO> findAll(Integer id) {
		List<FavoriteDAO> listFavoriteDAO = favoriteRepository.findAll(id);
		List<FavoriteDTO> listFavoriteDTO = new ArrayList<FavoriteDTO>();
		
		for (FavoriteDAO favoriteDAO : listFavoriteDAO) {
			FavoriteDTO favoriteDTO = new FavoriteDTO();
			favoriteDTO.setId(favoriteDAO.getId());
			favoriteDTO.setId_song(favoriteDAO.getId_song());
			favoriteDTO.setId_user(favoriteDAO.getId_user());
			listFavoriteDTO.add(favoriteDTO);
		}
		return listFavoriteDTO;
	}

	@Override
	public Integer deleteFavorite(Integer id) {
		return favoriteRepository.deleteFavorite(id); 
		
	}

	@Override
	public Integer addFavorite(FavoritePostRequest favorite) {
		return favoriteRepository.addFavorite(favorite);
	}

}
