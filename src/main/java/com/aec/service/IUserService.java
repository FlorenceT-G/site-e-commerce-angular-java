package com.aec.service;

import java.util.List;
import java.util.Optional;

import com.aec.entity.User;

public interface IUserService {
	
	//public Optional<User> logIn(String username, String password);
	public void nouvelUtilisateur(User u);
	public void supprimerUtilisateur(int id);
	public List<User> tousUtilisateurs();
	
	public Optional<User> chercherParUsername(String username);
}
