package com.example.Reto1_Grupo3.security.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RegistrationCheckRequest {

	private String login;
	private String email;

	
	
	//Constructors
	
	public RegistrationCheckRequest() {}
	
	public RegistrationCheckRequest(String login,String email,String password) {
		super();
		this.login = login;
		this.email = email;
	}
	
	//Getters and Setters
	
	
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

	@Override
	public String toString() {
		return "RegistrationCheckRequest [login=" + login + ", email=" + email + "]";
	}

	
	
	
	
	
	
	

	
	
	
	
	
}
