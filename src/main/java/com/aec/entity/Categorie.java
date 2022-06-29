package com.aec.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategorie;
	private String labelCategorie;
	@Column(name="descr")
	private String desc;
	
	@OneToMany
	@JoinColumn(name="idProduct")
	List<Product> lProducts;

	public Categorie(int idCategorie, String labelCategorie, String desc) {
		this.idCategorie = idCategorie;
		this.labelCategorie = labelCategorie;
		this.desc = desc;
	}

	public Categorie(int idCategorie, String labelCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.labelCategorie = labelCategorie;
	}
	
	public Categorie(String labelCategorie, String desc) {
		super();
		this.labelCategorie = labelCategorie;
		this.desc = desc;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public String getLabelCategorie() {
		return labelCategorie;
	}

	public String getDesc() {
		return desc;
	}

	public List<Product> getlProducts() {
		return lProducts;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setLabelCategorie(String labelCategorie) {
		this.labelCategorie = labelCategorie;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setlProducts(List<Product> lProducts) {
		this.lProducts = lProducts;
	}
	
	
}
