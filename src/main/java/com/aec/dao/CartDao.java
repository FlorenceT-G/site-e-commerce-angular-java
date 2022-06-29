package com.aec.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.aec.entity.Cart;
import com.aec.entity.CartLine;

@Repository
public class CartDao implements ICartDao {
	
	static ArrayList<Cart> lCarts = new ArrayList<>();
	
	public Cart newCart(CartLine cl) {
		System.out.println("new cart");
		ArrayList<CartLine> _lcl = new ArrayList<>();
		_lcl.add(cl);
		Cart c = new Cart(_lcl);	
		lCarts.add(c);
		System.out.println("ok");
		return c; 
	}

	public void updateCart(int idCart, CartLine cl) {
		System.out.println("update cart");
		for(int i = 0 ; i < lCarts.size() ; i++) {
			if(lCarts.get(i).getIdCart() == idCart) {
				lCarts.get(i).getlCartLines().add(cl);
			}
		}
		System.out.println("ok");
	}

	public void deleteFromCart(int idCart, CartLine cl) {
		for(int i = 0 ; i < lCarts.size() ; i++) {
			if(lCarts.get(i).getIdCart() == idCart) {
				lCarts.get(i).getlCartLines().remove(cl);
			}
		}
	}
}