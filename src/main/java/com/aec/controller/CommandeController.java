package com.aec.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aec.entity.Cart;
import com.aec.entity.CartLine;
import com.aec.entity.Order;
import com.aec.entity.OrderLine;
import com.aec.entity.User;
import com.aec.service.ICartLineService;
import com.aec.service.ICartService;
import com.aec.service.IOrderLineService;
import com.aec.service.IOrderService;
import com.aec.service.IProductService;
import com.aec.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CommandeController {

	@Autowired
	IOrderService orderService;
	@Autowired
	IOrderLineService orderlineService;
	@Autowired
	ICartService cartService;
	@Autowired
	ICartLineService carlineService;
	@Autowired
	IUserService userService;
	@Autowired
	IProductService productService;
	
	@PostMapping("/commandes")
	public void String(HttpSession s) {
		// gestion de la commande
		Optional<User> u = userService.chercherParUsername(((UserDetails)s.getAttribute("user")).getUsername());
		Order o = new Order(LocalDate.now(), u.get());
		
		Cart cart = (Cart) s.getAttribute("panier");
		List<OrderLine> lOrderLines = new ArrayList<>();
		
		for (CartLine cartline : cart.getlCartLines()) lOrderLines.add(new OrderLine(cartline.getQty(), cartline.getP(), o));
		
		o.setLOrderLines(lOrderLines);
		orderService.insererOrder(o);
		
		// gestion des stocks produits
		for(OrderLine orderline : o.getLOrderLines()) 
			orderline.getProduct().setStock(orderline.getProduct().getStock() - orderline.getQty());
	}
	
	@GetMapping("/commandes")
	public List<Order> toutesCommandes() {
		return orderService.toutesCommandes();
	}
	
	@GetMapping("/commandes/{id}")
	public Optional<Order> commandeParId(@PathVariable("id")int idOrder) {
		return orderService.chercherCommande(idOrder);
	}
}
