package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.Song;
import com.example.Reto1_Grupo3.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SongServicempl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Override
	public List<Song> findAll() {
		
		return songRepository.findAll();
	}

	
}
