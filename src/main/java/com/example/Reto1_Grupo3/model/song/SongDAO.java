package com.example.Reto1_Grupo3.model.song;

public class SongDAO {
	private int id;
	private String url;
	private String title;
	private String author;
	
	
	public SongDAO() {
		
	}
	public SongDAO(int id, String url, String title, String author) {
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
	public String getTitulo() {
		return title;
	}
	public void setTitulo(String titulo) {
		this.title = titulo;
	}
	public String getAutor() {
		return author;
	}
	public void setAutor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "SongDAO [id=" + id + ", url=" + url + ", title=" + title + ", author=" + author + "]";
	}
	
	

}
