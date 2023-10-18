package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;
import com.example.Reto1_Grupo3.model.song.SongGetResponse;
import com.example.Reto1_Grupo3.model.song.SongPostRequest;

public interface SongService {
	
	List<SongDTO> findAll();

	List<SongDTO> findSongById(int id);

	int createSong(SongDTO songDTO);

}
