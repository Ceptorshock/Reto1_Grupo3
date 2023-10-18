package com.example.Reto1_Grupo3.model.song;

public class SongDTO {

	private int id;
	private String url;
	private String title;
	private String author;
	
	
	public SongDTO() {
		
	}


	public SongDTO(int id, String url, String title, String author) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.author = author;
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
		return "SongDTO [id=" + id + ", url=" + url + ", title=" + title + ", author=" + author + "]";
	}
	
	

	
}