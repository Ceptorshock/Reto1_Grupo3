package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.exceptions.song.SongEmptyListException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotFoundException;
import com.example.Reto1_Grupo3.model.song.SongDAO;




public interface SongRepository {

	List<SongDAO> findAllWithId(int id_user) throws SongEmptyListException;
	
	List<SongDAO> findAll() throws SongEmptyListException;
	
	List<SongDAO> findSongById(int id) throws SongNotFoundException;
	
	int createSong (SongDAO songDAO) throws SongNotCreatedException;
	
	int updateSong(SongDAO songDAO) throws SongNotFoundException;
	
	int deleteSongById(int id) throws SongNotFoundException;
	
	List<SongDAO> findAllFavorite(Integer id) throws SongNotFoundException;
}
