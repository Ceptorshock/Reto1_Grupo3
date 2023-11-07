package com.example.Reto1_Grupo3.security.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserLoginRequest {
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String login;
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	
	
	//Constructors
	
	public UserLoginRequest() {}
	
	public UserLoginRequest(@NotNull @NotBlank @NotEmpty String login,
			@NotNull @NotBlank @NotEmpty String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	
	//Getters and Setters
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
		return "UserLoginRequest [login=" + login + ", password=" + password + "]";
	}

	
	
	

	
	
	
	
	
	

	
	
	
	
	
}
