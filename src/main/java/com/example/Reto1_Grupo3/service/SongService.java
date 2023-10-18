package com.example.Reto1_Grupo3.service;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.SongDAO;

public interface SongService {
	
	List<SongDAO> findAll();

}
