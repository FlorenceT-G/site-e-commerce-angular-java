package com.aec.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.aec.entity.CartLine;
import com.aec.entity.Product;

@Repository
public class CartLineDao implements ICartLineDao {

	ArrayList<CartLine> lCartLines = new ArrayList<>();
	
	public CartLine newCartLine(Product p, int qty) {
		System.out.println("newCartline");
		CartLine cl = new CartLine(p, qty);
		lCartLines.add(cl);
		System.out.println("OK");
		return cl;
	}
}