package com.example.Reto1_Grupo3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.model.favorite.FavoriteDAO;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;
import com.example.Reto1_Grupo3.service.FavoriteService;



@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<FavoriteDAO> findAll(Integer id) {
		try {
			return jdbcTemplate.query("select * from favorite where id_user = ?", BeanPropertyRowMapper.newInstance(FavoriteDAO.class), id);			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Integer addFavorite(FavoritePostRequest favorite) {
		return jdbcTemplate.update("insert into favorite (id_song, id_user) Values (?,?)", 
				new Object[] {
						favorite.getId_song(), favorite.getId_user()
				}
		);
	}

	@Override
	public Integer deleteFavorite(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("Delete from favorite where id = ?", id);
		
	}

	@Override
	public boolean findFavorite(FavoritePostRequest favorite) {
		try {
			FavoriteDAO favoriteDAO = jdbcTemplate.queryForObject("Select * from favorite where id_song = ? and id_user = ?", BeanPropertyRowMapper.newInstance(FavoriteDAO.class), favorite.getId_song(), favorite.getId_user());			
			if(favorite.getId_song() == favoriteDAO.getId_song() && favorite.getId_user() == favoriteDAO.getId_user()) {
				return true;
			}else {
				System.out.println("aaa");
				return false;
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println("aaa2131");
			return false;
		}
	}

}
