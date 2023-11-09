package com.example.Reto1_Grupo3.security.model;

public class UserLoginResponse {

	private String login;
	private String accessToken;
	private Integer id;
	
	public UserLoginResponse() {
		
	}
	
	public UserLoginResponse(String login, String accessToken, Integer id) {
		super();
		this.login = login;
		this.accessToken = accessToken;
		this.id = id;
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

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserLoginResponse [login=" + login + ", accessToken=" + accessToken + ", id=" + id + "]";
	}

	
	
	
	
	
}
