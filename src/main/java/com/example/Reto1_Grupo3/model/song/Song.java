package com.example.Reto1_Grupo3.model.song;

public class Song {
	private int id;
	private String url;
	private String titulo;
	private String Autor;
	
	
	
	public Song(int id, String url, String titulo, String autor) {
		super();
		this.id = id;
		this.url = url;
		this.titulo = titulo;
		Autor = autor;
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
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	
	

}
