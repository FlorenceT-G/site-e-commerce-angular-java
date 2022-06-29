package com.aec.entity;

public class CartLine {
	
	private int idCartLine;
	
	private Product p;
	private int qty;
	
	public CartLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartLine(Product p, int qty) {
		super();
		this.p = p;
		this.qty = qty;
	}

	public int getIdCartLine() {
		return idCartLine;
	}
	public Product getP() {
		return p;
	}
	public int getQty() {
		return qty;
	}
	public void setIdCartLine(int idCartLine) {
		this.idCartLine = idCartLine;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
