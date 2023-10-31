package com.example.Reto1_Grupo3.model.song;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SongPostRequest {

	private int id;
	@NotEmpty
	@NotBlank
	@NotNull
	private String url;
	
	private String title;
	private String author;
	private boolean favorite;
	
	public SongPostRequest() {
		
	}


	public SongPostRequest(
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco")
			@NotNull (message = "No puede ser nulo") int id, 
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco")
			@NotNull (message = "No puede ser nulo") String url,
			String title, String author, boolean favorite) {
		
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.author = author;
		this.favorite = favorite;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public boolean isFavorite() {
		return favorite;
	}


	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}


	@Override
	public String toString() {
		return "SongPostRequest [id=" + id + ", url=" + url + ", title=" + title + ", author=" + author + ", favorite="
				+ favorite + "]";
	}



}
