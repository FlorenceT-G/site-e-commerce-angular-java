package com.aec.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.aec.entity.OrderLine;

@Service
public interface IOrderLineService {
	public void insererOrderLine(OrderLine ol);
	public void deleteOrderLine(int idOrderLine);
	public Optional<OrderLine> chercherOrderLine(int idOrderLine);
}
