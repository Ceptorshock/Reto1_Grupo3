package com.example.Reto1_Grupo3.model.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserPostRequest {

	private int id;
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;
	@NotNull
	@NotBlank
	@NotEmpty
	private String surname;
	@NotNull
	@NotBlank
	@NotEmpty
	private String login;
	@Email
	@NotNull
	@NotBlank
	@NotEmpty
	private String email;
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	@NotNull
	@NotBlank
	@NotEmpty
	private String oldPassword;
	
	
	//Constructors
	
	public UserPostRequest() {}
	
	public UserPostRequest(@NotNull @NotBlank @NotEmpty String login,
			@NotNull @NotBlank @NotEmpty String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public UserPostRequest(@NotNull @NotBlank @NotEmpty String login,
			@NotNull @NotBlank @NotEmpty String password,
			@NotNull @NotBlank @NotEmpty String oldPassword) {
		super();
		this.login = login;
		this.password = password;
		this.oldPassword = oldPassword;
	}
	
	public UserPostRequest(int id,
			@NotNull @NotBlank @NotEmpty String name,
			@NotNull @NotBlank @NotEmpty String surname,
			@NotNull @NotBlank @NotEmpty String login,
			@NotNull @NotBlank @NotEmpty @Email String email,
			@NotNull @NotBlank @NotEmpty String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.email = email;
		this.password = password;
	}
	
	public UserPostRequest(int id, 
			@NotNull @NotBlank @NotEmpty String name,
			@NotNull @NotBlank @NotEmpty String surname,
			@NotNull @NotBlank @NotEmpty String login,
			@NotNull @NotBlank @NotEmpty @Email String email,
			@NotNull @NotBlank @NotEmpty String password,
			@NotNull @NotBlank @NotEmpty String oldPassword) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
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
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	//ToString
	
	@Override
	public String toString() {
		return "UserPostRequest [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", email="
				+ email + ", password=" + password + ", oldPassword=" + oldPassword + "]";
	}

	
	
	
	
	
	

	
	
	
	
	
}
