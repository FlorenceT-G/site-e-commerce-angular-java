package com.aec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.IOrderLineDao;
import com.aec.entity.OrderLine;

@Service
public class OrderLineService implements IOrderLineService {
	
	@Autowired
	IOrderLineDao orderLineDao;

	public void insererOrderLine(OrderLine ol) {
		orderLineDao.save(ol);
	}

	public void deleteOrderLine(int idOrderLine) {
		orderLineDao.deleteById(idOrderLine);
	}

	public Optional<OrderLine> chercherOrderLine(int idOrderLine) {
		return orderLineDao.findById(idOrderLine);
	}
}
