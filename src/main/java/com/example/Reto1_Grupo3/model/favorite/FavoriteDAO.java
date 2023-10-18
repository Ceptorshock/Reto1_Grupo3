package com.example.Reto1_Grupo3.model.favorite;


public class FavoriteDAO {

	private Integer id_user;
	private Integer id_song;
	private Integer id;
	@Override
	public String toString() {
		return "FavoriteDAO [id_user=" + id_user + ", id_song=" + id_song + ", id=" + id + "]";
	}
	public FavoriteDAO(Integer id_user, Integer id_song, Integer id) {
		super();
		this.id_user = id_user;
		this.id_song = id_song;
		this.id = id;
	}
	public FavoriteDAO() {
		super();
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_song() {
		return id_song;
	}
	public void setId_song(Integer id_song) {
		this.id_song = id_song;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
