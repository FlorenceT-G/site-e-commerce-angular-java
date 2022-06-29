package com.aec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idOrderLine;
	private int qty;
	
	@OneToOne
	@JoinColumn(name="idProduct")
	private Product product;
	@ManyToOne
	@JoinColumn(name="idOrder")
	private Order order;
	
	public OrderLine(int qty, Product product, Order order) {
		this.qty = qty;
		this.product = product;
		this.order = order;
	}

	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdOrderLine() {
		return idOrderLine;
	}
	public int getQty() {
		return qty;
	}
	public Product getProduct() {
		return product;
	}
	public Order getOrder() {
		return order;
	}
	public void setIdOrderLine(int idOrderLine) {
		this.idOrderLine = idOrderLine;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setCommand(Order order) {
		this.order = order;
	} 
	
}
