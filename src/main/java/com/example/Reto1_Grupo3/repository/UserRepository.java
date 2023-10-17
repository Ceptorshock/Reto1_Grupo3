package com.example.Reto1_Grupo3.repository;

import com.example.Reto1_Grupo3.model.user.UserDAO;

public interface UserRepository {

	UserDAO findByEmail(String email);
	
}
