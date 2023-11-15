package com.example.Reto1_Grupo3.security.model;

public class UserGetResponse {

	private int id;
	private String name;
	private String surname;
	private String login;
	private String email;
	
	//Constructors
	
	public UserGetResponse() {}
	
	public UserGetResponse(int id, String name, String surname, String login, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.email = email;
	}
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	//ToString

	@Override
	public String toString() {
		return "UserGetResponse [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", email="
				+ email + "]";
	}
	
	
	
	
}
