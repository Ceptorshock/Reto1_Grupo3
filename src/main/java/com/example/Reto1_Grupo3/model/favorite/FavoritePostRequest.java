package com.example.Reto1_Grupo3.model.favorite;

public class FavoritePostRequest {
	private Integer id_user;
	private Integer id_song;

	@Override
	public String toString() {
		return "FavoritePostRequest [id_user=" + id_user + ", id_song=" + id_song + "]";
	}
	public FavoritePostRequest(Integer id_user, Integer id_song) {
		super();
		this.id_user = id_user;
		this.id_song = id_song;
	}
	public FavoritePostRequest() {
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
	
	
}
