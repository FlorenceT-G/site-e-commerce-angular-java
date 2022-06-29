package com.aec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.IOrderDao;
import com.aec.entity.Order;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	IOrderDao orderDao;

	public void insererOrder(Order o) {
		orderDao.save(o);
	}

	public void deleteOrder(int idOrder) {
		orderDao.deleteById(idOrder);
	}

	public List<Order> toutesCommandes() {
		return orderDao.findAll();
	}

	public List<Order> CommandesClient(int id) {
		return orderDao.findOrdersByIdUser(id);
	}

	public Optional<Order> chercherCommande(int idOrder) {
		return orderDao.findById(idOrder);
	}
}
