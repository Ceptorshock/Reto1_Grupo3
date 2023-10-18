package com.example.Reto1_Grupo3.service;

import java.util.ArrayList;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;

import com.example.Reto1_Grupo3.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SongServicempl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Override
	public List<SongDTO> findAll() {
		List<SongDAO> listSongsDAO=songRepository.findAll();
		List<SongDTO> listSongsDTO = new ArrayList<SongDTO>();
	
		for(SongDAO songDAO:listSongsDAO) {
			SongDTO songDTO = new SongDTO();
			songDTO.setId(songDAO.getId());
			songDTO.setUrl(songDAO.getUrl());
			songDTO.setTitle(songDAO.getTitle());
			songDTO.setAuthor(songDAO.getAuthor());
			
			listSongsDTO.add(songDTO);
		}
		
		
		return listSongsDTO;
	}

	@Override
	public List<SongDTO> findSongById(int id) {
		// TODO Auto-generated method stub
		List<SongDAO> listSongsDAO=songRepository.findSongById(id);
		List<SongDTO> listSongsDTO = new ArrayList<SongDTO>();
	
		for(SongDAO songDAO:listSongsDAO) {
			SongDTO songDTO = new SongDTO();
			songDTO.setId(songDAO.getId());
			songDTO.setUrl(songDAO.getUrl());
			songDTO.setTitle(songDAO.getTitle());
			songDTO.setAuthor(songDAO.getAuthor());
			
			listSongsDTO.add(songDTO);
		}
		return listSongsDTO;
		
	}

	@Override
	public int createSong(SongDTO songDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
