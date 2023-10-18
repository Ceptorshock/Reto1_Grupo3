package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.song.Song;
@Repository
public class JdbcSongReposiory implements SongRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Song> findAll() {
		try {
			return jdbcTemplate.query("SELECT * from songs", 
					BeanPropertyRowMapper.newInstance(Song.class));
			
		} catch (IncorrectResultSizeDataAccessException e) {
			// TODO: handle exception
		}
		return null;
	}

}
