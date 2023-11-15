package com.example.Reto1_Grupo3.security.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserPutRequest {
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	@NotNull
	@NotBlank
	@NotEmpty
	private String oldPassword;
	
	
	//Constructors
	
	public UserPutRequest() {}

	
	public UserPutRequest(@NotNull @NotBlank @NotEmpty String password,
			@NotNull @NotBlank @NotEmpty String oldPassword) {
		super();
		this.password = password;
		this.oldPassword = oldPassword;
	}
	
	//Getters and Setters


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
		return "UserPutRequest [password=" + password + ", oldPassword=" + oldPassword + "]";
	}

	
	

	
	
	
	
	
	

	
	
	
	
	
}
