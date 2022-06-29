package com.aec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aec.entity.Order;

@Service
public interface IOrderService {

	public void insererOrder(Order o);
	public void deleteOrder(int idOrder);
	public List<Order> toutesCommandes();
	public List<Order> CommandesClient(int id);
	public Optional<Order> chercherCommande(int idOrder);

}
