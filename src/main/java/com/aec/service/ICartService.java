package com.aec.service;

import com.aec.entity.Cart;
import com.aec.entity.CartLine;

public interface ICartService {
	public Cart nouveauPanier(CartLine cl);
	public void modifierPanier(int idCart, CartLine cl);
	public void supprimerdupanier(int idCart, CartLine cl);
}
