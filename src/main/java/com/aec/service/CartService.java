package com.aec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.ICartDao;
import com.aec.entity.Cart;
import com.aec.entity.CartLine;

@Service
public class CartService implements ICartService {
	
	@Autowired
	ICartDao cDao;
	
	public ICartDao getcDao() { return cDao; }
	public void setcDao(ICartDao cDao) { this.cDao = cDao; }

	public Cart nouveauPanier(CartLine c) {
		return cDao.newCart(c);
	}

	public void modifierPanier(int idCart, CartLine cl) {
		cDao.updateCart(idCart, cl);
	}

	public void supprimerdupanier(int idCart, CartLine cl) {
		cDao.deleteFromCart(idCart, cl);
	}
}
