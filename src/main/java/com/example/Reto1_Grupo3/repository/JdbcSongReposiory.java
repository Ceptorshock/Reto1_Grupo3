package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.song.SongDAO;
import com.example.Reto1_Grupo3.model.song.SongDTO;
import com.example.Reto1_Grupo3.model.song.SongGetResponse;
import com.example.Reto1_Grupo3.model.song.SongPostRequest;
@Repository
public class JdbcSongReposiory implements SongRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<SongDAO> findAll() {
		try {
			return jdbcTemplate.query("SELECT * from songs", 
					BeanPropertyRowMapper.newInstance(SongDAO.class));
			
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		
	}
	@Override
	public List<SongDAO> findSongById(int id) {
		try {
			return jdbcTemplate.query("SELECT * from songs where id = ?", 
					BeanPropertyRowMapper.newInstance(SongDAO.class), id);
			
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	@Override
	public int createSong(SongDTO songDTO) {
		return jdbcTemplate.update(
				"Insert into songs (url, title, author) values(?, ?, ?)",
				new Object[] {songDTO.getUrl(),songDTO.getTitle(), songDTO.getAuthor() }
				);
	}
	@Override
	public int updateSong(SongDTO songDTO) {
		return jdbcTemplate.update(
				"UPDATE songs SET url = ?, title = ?, author = ? where id = ?", 
				new Object[] {
						songDTO.getUrl(),songDTO.getTitle(), songDTO.getAuthor(), songDTO.getId()
				}
				);
	}
	@Override
	public int deleteSongById(int id) {
		return jdbcTemplate.update(
				"Delete from songs where id=?", id);
	}
	
	

}
