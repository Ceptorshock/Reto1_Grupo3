package com.example.Reto1_Grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDTO;
import com.example.Reto1_Grupo3.model.favorite.FavoriteGetResponse;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;
import com.example.Reto1_Grupo3.model.song.SongGetResponse;
import com.example.Reto1_Grupo3.service.FavoriteService;
import com.example.Reto1_Grupo3.service.SongService;

@RestController
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
		

	@DeleteMapping("/fav/{id}")
	public Integer deleteFavorite(@PathVariable("id") Integer id) {
		return favoriteService.deleteFavorite(id);
	}
	
	@PostMapping("/fav")
	public Integer createFavorite(@RequestBody FavoritePostRequest favorite) {
		return favoriteService.addFavorite(favorite);
	}
	
	private List<FavoriteGetResponse> fromDTOToGetResponse(List<FavoriteDTO> listFavoriteDTO) {	
		List<FavoriteGetResponse> listFavoriteGetResponse = new ArrayList<FavoriteGetResponse>();
		
		for (FavoriteDTO favoriteDTO : listFavoriteDTO) {
			listFavoriteGetResponse.add(
					new FavoriteGetResponse(
							favoriteDTO.getId(), 
							favoriteDTO.getId_song(), 
							favoriteDTO.getId_user()));
		}
		
		return listFavoriteGetResponse;
	}

}
