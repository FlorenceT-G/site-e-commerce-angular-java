package com.aec.dao;

import com.aec.entity.CartLine;
import com.aec.entity.Product;

public interface ICartLineDao  {
	public CartLine newCartLine(Product p, int qty);
}
