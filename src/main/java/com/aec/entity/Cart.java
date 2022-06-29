package com.aec.entity;

import java.util.ArrayList;

public class Cart {
	
	private int idCart;
	
	ArrayList<CartLine> lCartLines;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(ArrayList<CartLine> lCartLines) {
		this.lCartLines = lCartLines;
	}

	public Cart(int idCart) {
		super();
		this.idCart = idCart;
	}

	public int getIdCart() {
		return idCart;
	}

	public ArrayList<CartLine> getlCartLines() {
		return lCartLines;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public void setlCartLines(ArrayList<CartLine> lCartLines) {
		this.lCartLines = lCartLines;
	}
}
