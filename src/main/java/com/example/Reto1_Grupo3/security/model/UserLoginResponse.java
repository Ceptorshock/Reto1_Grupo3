package com.example.Reto1_Grupo3.security.model;

public class UserLoginResponse {

	private String login;
	private String accessToken;
	
	public UserLoginResponse() {
		
	}
	
	public UserLoginResponse(String login, String accessToken) {
		super();
		this.login = login;
		this.accessToken = accessToken;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "UserLoginResponse [login=" + login + ", accessToken=" + accessToken + "]";
	}
	
	
	
	
}
