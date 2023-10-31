package com.example.Reto1_Grupo3.model.song;

public class SongDAO {
	private int id;
	private String url;
	private String title;
	private String author;
	private boolean favorite;
	
	public SongDAO() {
	}


	public SongDAO(int id, String url, String title, String author, boolean favorite) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.author = author;
		this.favorite = favorite;
	}


	public boolean isFavorite() {
		return favorite;
	}


	public void setFavorite(boolean favorite) {
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


	@Override
	public String toString() {
		return "SongDAO [id=" + id + ", url=" + url + ", title=" + title + ", author=" + author + ", favorite="
				+ favorite + "]";
	}




	
	
	

}
