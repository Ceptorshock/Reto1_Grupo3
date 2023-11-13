package com.example.Reto1_Grupo3.service;

import java.util.ArrayList;

import java.util.List;

import com.example.Reto1_Grupo3.exceptions.song.SongEmptyListException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotFoundException;
import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;

import com.example.Reto1_Grupo3.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SongServicempl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Override
	public List<SongDTO> findAll(int id_user) throws SongEmptyListException{
		List<SongDAO> listSongsDAO = new ArrayList<SongDAO>();
		if(id_user == 0) {
			listSongsDAO = songRepository.findAll();
		}else {
			listSongsDAO = songRepository.findAllWithId(id_user); 
		}
		System.out.println(listSongsDAO);
		List<SongDTO> listSongsDTO = new ArrayList<SongDTO>();
	
		for(SongDAO songDAO:listSongsDAO) {
			
			listSongsDTO.add(convertDAOtoDTO(songDAO));
		}
		
		
		return listSongsDTO;
	}

	@Override
	public List<SongDTO> findSongById(int id) throws SongNotFoundException {
		// TODO Auto-generated method stub
		List<SongDAO> listSongsDAO=songRepository.findSongById(id);
		List<SongDTO> listSongsDTO = new ArrayList<SongDTO>();
	
		for(SongDAO songDAO:listSongsDAO) {
		
			listSongsDTO.add(convertDAOtoDTO(songDAO));
		}
		return listSongsDTO;
		
	}
	
	@Override
	public List<SongDTO> findAllFavorite(Integer id) throws SongNotFoundException{
		List<SongDAO> list = songRepository.findAllFavorite(id);
		List<SongDTO>  listPostRequest = new ArrayList<SongDTO>();
		for (SongDAO songDAO : list) {
			listPostRequest.add(convertDAOtoDTO(songDAO));
		}
		return listPostRequest;
	}
	

	@Override
	public int createSong(SongDTO songDTO) throws SongNotCreatedException{
		// TODO Auto-generated method stub
		return songRepository.createSong(convertDTOtoDAO(songDTO));
	}

	@Override
	public int deleteSongById(int id) throws SongNotFoundException{
		// TODO Auto-generated method stub
		return songRepository.deleteSongById(id);
	}
	@Override
	public int updateSong(SongDTO songDTO) throws SongNotFoundException{
		// TODO Auto-generated method stub
		return songRepository.updateSong(convertDTOtoDAO(songDTO));
	}
	
	private SongDTO convertDAOtoDTO(SongDAO songDAO) {
		return new SongDTO(
				songDAO.getId(),
				songDAO.getUrl(),
				songDAO.getTitle(),
				songDAO.getAuthor(),
				songDAO.isFavorite()
				);
		}
	private SongDAO convertDTOtoDAO(SongDTO songDTO) {
		return new SongDAO(
				songDTO.getId(),
				songDTO.getUrl(),
				songDTO.getTitle(),
				songDTO.getAuthor(),
				songDTO.isFavorite()
				);	
	}





}
