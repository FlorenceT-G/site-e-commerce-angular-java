package com.aec.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String dateNaissance;
	@Column(name="mail")
    private String email;
    private String username;
    private String password;
   
    @OneToOne
    @JoinColumn(name="idRole")
    private Role role;

    @OneToMany(mappedBy = "u")
    private List<Order> lOrders;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String nom, String prenom, String username, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.role = role;
	}
	
	public User(String nom, String prenom, String dateNaissance, String email, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Role getRole() {
		return role;
	}
	public List<Order> getlOrders() {
		return lOrders;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setlOrders(ArrayList<Order> lOrders) {
		this.lOrders = lOrders;
	}
}

