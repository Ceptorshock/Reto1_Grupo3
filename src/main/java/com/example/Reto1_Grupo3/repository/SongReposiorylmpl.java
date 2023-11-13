package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.exceptions.song.SongEmptyListException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotFoundException;
import com.example.Reto1_Grupo3.model.song.SongDAO;
@Repository
public class SongReposiorylmpl implements SongRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<SongDAO> findAllWithId(int id_user) throws SongEmptyListException{
		try {
			return jdbcTemplate.query(""
					+ "SELECT \r\n"
					+ "    songs.*,\r\n"
					+ "    CASE\r\n"
					+ "        WHEN favorite.id_song IS NOT NULL THEN 1\r\n"
					+ "        ELSE 0\r\n"
					+ "    END AS favorite\r\n"
					+ "FROM songs\r\n"
					+ "LEFT JOIN favorite ON songs.id = favorite.id_song AND favorite.id_user = ?;", 
					BeanPropertyRowMapper.newInstance(SongDAO.class), id_user);
			
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new SongEmptyListException("Song list is empty in Repository");
		}
		
	}
	@Override
	public List<SongDAO> findAll() throws SongEmptyListException{
		try {
			return jdbcTemplate.query(""
					+ "SELECT * from songs", 
					BeanPropertyRowMapper.newInstance(SongDAO.class));
			
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new SongEmptyListException("Song list is empty in Repository");
		}
		
	}
	@Override
	public List<SongDAO> findSongById(int id) throws SongNotFoundException{
		try {
			return jdbcTemplate.query("SELECT * from songs where id = ?", 
					BeanPropertyRowMapper.newInstance(SongDAO.class), id);
			
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	@Override
	public int createSong(SongDAO songDAO) throws SongNotCreatedException{
		return jdbcTemplate.update(
				"Insert into songs (url, title, author) values(?, ?, ?)",
				new Object[] {songDAO.getUrl(),songDAO.getTitle(), songDAO.getAuthor() }
				);
	}
	@Override
	public int updateSong(SongDAO songDAO) throws SongNotFoundException{
		return jdbcTemplate.update(
				"UPDATE songs SET url = ?, title = ?, author = ? where id = ?", 
				new Object[] {
						songDAO.getUrl(),songDAO.getTitle(), songDAO.getAuthor(), songDAO.getId()
				}
				);
	}
	@Override
	public int deleteSongById(int id) throws SongNotFoundException{
		return jdbcTemplate.update(
				"Delete from songs where id=?", id);
	}
	
	@Override
	public List<SongDAO> findAllFavorite(Integer id) throws SongNotFoundException{
		try {
			return jdbcTemplate.query("SELECT songs.id, songs.title, songs.author, songs.url FROM reto1.songs join favorite on songs.id = favorite.id_song where favorite.id_user = ?", BeanPropertyRowMapper.newInstance(SongDAO.class), id);			
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
