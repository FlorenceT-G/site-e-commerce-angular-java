package com.aec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idProduct;
	private String labelProduct;
	private String img;
	private int stock;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCat")
	private Categorie cat;

	
	
	public Product(String labelProduct, int stock) {
		this.labelProduct = labelProduct;
		this.stock = stock;
	}

	public Product(String labelProduct, String img, int stock) {
		super();
		this.labelProduct = labelProduct;
		this.img = img;
		this.stock = stock;
	}
	
	public Product(int idProduct, String labelProduct, String img, int stock) {
		super();
		this.idProduct = idProduct;
		this.labelProduct = labelProduct;
		this.img = img;
		this.stock = stock;
	}
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String labelProduct, String img, int stock, Categorie cat) {
		super();
		this.labelProduct = labelProduct;
		this.img = img;
		this.stock = stock;
		this.cat = cat;
	}
	
	public Product(int idProduct, String labelProduct, String img, int stock, Categorie cat) {
		super();
		this.idProduct = idProduct;
		this.labelProduct = labelProduct;
		this.img = img;
		this.stock = stock;
		this.cat = cat;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public String getLabelProduct() {
		return labelProduct;
	}

	public String getImg() {
		return img;
	}

	public int getStock() {
		return stock;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public void setLabelProduct(String labelProduct) {
		this.labelProduct = labelProduct;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
}
