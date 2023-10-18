package com.example.Reto1_Grupo3.model.user;

public class UserPostRequest {

	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String oldPassword;
	
	
	//Constructors
	
	public UserPostRequest() {}
	
	public UserPostRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UserPostRequest(String email, String password, String oldPassword) {
		super();
		this.email = email;
		this.password = password;
		this.oldPassword = oldPassword;
	}
	
	public UserPostRequest(int id, String name, String surname, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	public UserPostRequest(int id, String name, String surname, String email, String password, String oldPassword) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.oldPassword = oldPassword;
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
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	//ToString
	
	@Override
	public String toString() {
		return "UserPostRequest [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", oldPassword=" + oldPassword + "]";
	}
	
	
	

	
	
	
	
	
}
