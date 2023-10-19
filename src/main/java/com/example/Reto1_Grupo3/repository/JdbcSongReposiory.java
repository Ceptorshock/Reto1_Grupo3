package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDAO;
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
	public int createSong(SongDAO songDAO) {
		return jdbcTemplate.update(
				"Insert into songs (url, title, author) values(?, ?, ?)",
				new Object[] {songDAO.getUrl(),songDAO.getTitle(), songDAO.getAuthor() }
				);
	}
	@Override
	public int updateSong(SongDAO songDAO) {
		return jdbcTemplate.update(
				"UPDATE songs SET url = ?, title = ?, author = ? where id = ?", 
				new Object[] {
						songDAO.getUrl(),songDAO.getTitle(), songDAO.getAuthor(), songDAO.getId()
				}
				);
	}
	@Override
	public int deleteSongById(int id) {
		return jdbcTemplate.update(
				"Delete from songs where id=?", id);
	}
	
	@Override
	public List<SongDAO> findAllFavorite(Integer id) {
		try {
			return jdbcTemplate.query("SELECT songs.id, songs.title, songs.author, songs.url FROM reto1.songs join favorite on songs.id = favorite.id_song where favorite.id_user = ?", BeanPropertyRowMapper.newInstance(SongDAO.class), id);			
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
