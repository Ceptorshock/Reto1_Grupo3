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
		return fromDAOToDTO(favoriteRepository.findAll(id));
	}

	@Override
	public Integer deleteFavorite(Integer id) {
		return favoriteRepository.deleteFavorite(id); 
	}

	@Override
	public Integer addFavorite(FavoritePostRequest favorite) {
		if(!favoriteRepository.findFavorite(favorite)) {
			return favoriteRepository.addFavorite(favorite);			
		}else {
			return 0;
		}
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
