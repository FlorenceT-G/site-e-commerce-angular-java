package com.aec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.CartLineDao;
import com.aec.entity.CartLine;
import com.aec.entity.Product;

@Service
public class CartLineService implements ICartLineService {

    @Autowired
    CartLineDao clDao;

    public CartLine nouvelleCartLine(Product p, int qty) {
        return clDao.newCartLine(p, qty);
    }

}
