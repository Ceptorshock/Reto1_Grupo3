package com.example.Reto1_Grupo3.repository;

import java.util.List;

import com.example.Reto1_Grupo3.model.song.Song;

public interface SongRepository {

	List<Song> findAll();
}
