package com.example.Reto1_Grupo3.model.user;

public class UserDAO {

	private int id;
	private String name;
	private String surname;
	private String login;
	private String email;
	private String password;
	
	
	//Constructors
	
	public UserDAO() {}
	
	public UserDAO(int id, String name, String surname, String login, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//ToString

	@Override
	public String toString() {
		return "UserDAO [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
}
