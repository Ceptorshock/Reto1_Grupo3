package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.exceptions.song.SongEmptyListException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotFoundException;
import com.example.Reto1_Grupo3.model.song.SongDTO;


public interface SongService {
	
	List<SongDTO> findAll(int id_user) throws SongEmptyListException;

	List<SongDTO> findSongById(int id) throws SongNotFoundException;

	int createSong(SongDTO songDTO) throws SongNotCreatedException;
	
	int deleteSongById(int id)throws SongNotFoundException;
	
	int updateSong(SongDTO songDTOconvertRequestToDTO) throws SongNotFoundException;
	
	List<SongDTO> findAllFavorite(Integer id) throws SongNotFoundException;

	

	

}
