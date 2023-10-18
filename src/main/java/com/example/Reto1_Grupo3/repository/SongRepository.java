package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;



public interface SongRepository {

	List<SongDAO> findAll();
	
	List<SongDAO> findSongById(int id);
	
	int createSong (SongDAO songDAO);
	
	int updateSong(SongDAO songDAO);
	
	int deleteSongById(int id);
}
