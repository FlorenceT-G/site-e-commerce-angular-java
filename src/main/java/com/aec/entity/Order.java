package com.aec.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idOrder;
	private LocalDate dateOrder;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User u;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="idOrderLine")
	private List<OrderLine> lOrderLines;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Order(LocalDate dateOrder, User u, List<OrderLine> lOrderLines) {
		this.dateOrder = dateOrder;
		this.u = u;
		this.lOrderLines = lOrderLines;
	}



	public Order(LocalDate dateOrder, User u) {
		this.dateOrder = dateOrder;
		this.u = u;
	}

	public int getIdOrder() {
		return idOrder;
	}
	public LocalDate getDateOrder() {
		return dateOrder;
	}
	public User getU() {
		return u;
	}
	public List<OrderLine> getLOrderLines() {
		return lOrderLines;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}
	public void setU(User u) {
		this.u = u;
	}
	public void setLOrderLines(List<OrderLine> lOrderLines) {
		this.lOrderLines = lOrderLines;
	}
}
