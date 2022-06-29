package com.aec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.IUserDao;
import com.aec.entity.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDao uDao;

	// getters and setters
	public IUserDao getuDao() { return uDao; }
	public void setuDao(IUserDao uDao) { this.uDao = uDao; }
	
	//public Optional<User> logIn(String username, String password) {
	//	return uDao.findUserLogIn(username, password);
	//}
	
	public void nouvelUtilisateur(User u) {
		uDao.save(u);
	}
	
	public void supprimerUtilisateur(int id) {
		uDao.deleteById(id);
	}
	
	public Optional<User> chercherParUsername(String username) {
		return uDao.findByUsername(username);
	}
	
	public List<User> tousUtilisateurs() {
		return uDao.findAll();
	}

}
