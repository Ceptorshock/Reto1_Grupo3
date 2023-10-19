package com.example.Reto1_Grupo3.model.favorite;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FavoritePostRequest {
	
	@NotNull
	@Min(0)
	private Integer id_user;
	

	@NotNull
	@Min(0)
	private Integer id_song;

	@Override
	public String toString() {
		return "FavoritePostRequest [id_user=" + id_user + ", id_song=" + id_song + "]";
	}
	public FavoritePostRequest(
			@NotEmpty(message = "no puede estar vacio") @NotBlank(message = "no puede estar en blanco") @NotNull(message = "no puede ser nulo") Integer id_user, 
			@NotEmpty(message = "no puede estar vacio") @NotBlank(message = "no puede estar en blanco") @NotNull(message = "no puede ser nulo") Integer id_song) {
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
