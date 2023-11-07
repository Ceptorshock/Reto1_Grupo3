package com.example.Reto1_Grupo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.favourites.FavoriteNotDeletedException;
import com.example.Reto1_Grupo3.model.favorite.FavoritePostRequest;



@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public Integer addFavorite(FavoritePostRequest favorite) throws FavoriteNotCreatedException {
		System.out.println(favorite.toString());
		try {
			return jdbcTemplate.update("insert into favorite (id_song, id_user) Values (?,?)", 
					new Object[] {
							favorite.getId_song(), favorite.getId_user()
			}
					);			
		} catch (DuplicateKeyException e) {
			System.out.println(e);
			throw new FavoriteNotCreatedException("Favorite is created");
		}
	}

	@Override
	public Integer deleteFavorite(Integer id_song, Integer id_user) throws FavoriteNotDeletedException {
		try {
			return jdbcTemplate.update("Delete from favorite where id_user = ? and id_song = ?", id_user, id_song);			
		}
		catch (IncorrectResultSizeDataAccessException e) {
			throw new FavoriteNotDeletedException("Favorite can´t be deleted");
		}
	}


}
