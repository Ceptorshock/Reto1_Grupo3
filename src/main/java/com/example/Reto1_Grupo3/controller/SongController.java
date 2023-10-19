package com.example.Reto1_Grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto1_Grupo3.model.favorite.FavoriteGetResponse;
import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;
import com.example.Reto1_Grupo3.model.song.SongGetResponse;
import com.example.Reto1_Grupo3.model.song.SongPostRequest;
import com.example.Reto1_Grupo3.service.SongService;




@RestController

public class SongController {
	@Autowired
	SongService songService;
	
	@GetMapping("/fav/{id}")
	public List<SongGetResponse> getAllFavorites(@PathVariable("id") Integer id ){		
		List<SongDTO> list = songService.findAllFavorite(id);
		List<SongGetResponse> listPostRequest = new ArrayList<SongGetResponse>();
		for (SongDTO songDTO : list) {
			listPostRequest.add(convertDTOtoResponse(songDTO));
		}
		return listPostRequest;
	}
	
	@GetMapping("/songs")
	public List<SongGetResponse> getSongs(){
		List<SongDTO> listSongsDAO = songService.findAll();
		List<SongGetResponse> listSongsGetREsponse= new ArrayList<SongGetResponse>();
		
		for(SongDTO songDTO: listSongsDAO ) {
			SongGetResponse songGetResponse = new SongGetResponse();
			songGetResponse.setId(songDTO.getId());
			songGetResponse.setUrl(songDTO.getUrl());
			songGetResponse.setTitle(songDTO.getTitle());
			songGetResponse.setAuthor(songDTO.getAuthor());
			
			listSongsGetREsponse.add(songGetResponse);
			
			
		}
		return listSongsGetREsponse;
	}
	@GetMapping("/songs/{id}")
	public List<SongGetResponse> getSongById(@PathVariable("id") int id){
		List<SongDTO> listSongsDAO = songService.findSongById(id);
		List<SongGetResponse> listSongsGetREsponse= new ArrayList<SongGetResponse>();
		
		for(SongDTO songDTO: listSongsDAO ) {
			SongGetResponse songGetResponse = new SongGetResponse();
			songGetResponse.setId(songDTO.getId());
			songGetResponse.setUrl(songDTO.getUrl());
			songGetResponse.setTitle(songDTO.getTitle());
			songGetResponse.setAuthor(songDTO.getAuthor());
			
			listSongsGetREsponse.add(songGetResponse);
			
			
		}
		return listSongsGetREsponse;
				
	}
	
	@PostMapping("/song")
	public int createSong(@RequestBody SongPostRequest songPostRequest) {
		
		songService.createSong(SongDTOconvertRequestToDTO(songPostRequest));

		
		return 0;
	}
	private SongDTO SongDTOconvertRequestToDTO(SongPostRequest songPostRequest) {
		SongDTO songDTO = new SongDTO(
				songPostRequest.getId(),
				songPostRequest.getUrl(),
				songPostRequest.getTitle(),
				songPostRequest.getAuthor());
		return songDTO;
	}
	private SongGetResponse convertDTOtoResponse(SongDTO songDTO) {
		return new SongGetResponse(
				songDTO.getId(),
				songDTO.getUrl(),
				songDTO.getTitle(),
				songDTO.getAuthor());
	}
}
