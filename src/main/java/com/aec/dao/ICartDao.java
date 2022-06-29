package com.aec.dao;

import com.aec.entity.Cart;
import com.aec.entity.CartLine;

public interface ICartDao  {
	
	public Cart newCart(CartLine cl);
	public void updateCart(int idCart, CartLine cl);
	public void deleteFromCart(int idCart, CartLine cl);

}
