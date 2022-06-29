package com.aec.service;

import com.aec.entity.CartLine;
import com.aec.entity.Product;

public interface ICartLineService {
    public CartLine nouvelleCartLine(Product p, int qty);
}
