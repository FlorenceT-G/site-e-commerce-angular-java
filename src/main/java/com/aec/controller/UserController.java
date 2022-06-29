package com.aec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aec.entity.Role;
import com.aec.entity.User;
import com.aec.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/users")
	public void insert(@RequestBody User user) {
		user.setRole(new Role(2));
		userService.nouvelUtilisateur(user);
	}
	
	@PutMapping("/users")
	public void modify(@RequestBody User user) {
		userService.nouvelUtilisateur(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable("id") int id) {
		userService.supprimerUtilisateur(id);
	}
	
	@GetMapping("/users")
	public List<User> tousUtilisateurs() {
		return userService.tousUtilisateurs();
	}
	
	@GetMapping("/users/{u}")
	public User getUser(@PathVariable("u") String username) {
		return  userService.chercherParUsername(username).get();
	}
}
