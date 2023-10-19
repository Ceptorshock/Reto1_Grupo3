package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.SongDTO;


public interface SongService {
	
	List<SongDTO> findAll();

	List<SongDTO> findSongById(int id);

	int createSong(SongDTO songDTO);
	
	List<SongDTO> findAllFavorite(Integer id);

}
