package com.aec.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aec.entity.Cart;
import com.aec.entity.CartLine;
import com.aec.entity.Product;
import com.aec.service.ICartLineService;
import com.aec.service.ICartService;
import com.aec.service.IProductService;

@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PanierController {

	@Autowired
	ICartService cartService;
	@Autowired
	ICartLineService cartlineService;
	@Autowired 
	IProductService productService;
	
	@RequestMapping("/panier")
	public void createCart(HttpSession s, @RequestBody int idProduit, @RequestBody int quantite) {
		Optional<Product> p = productService.trouverProduit(idProduit);
		
		Cart cart = (Cart) s.getAttribute("panier");
		
		if(ObjectUtils.isEmpty(cart)) {
			CartLine cl = cartlineService.nouvelleCartLine(p.get(), quantite);
			cart = cartService.nouveauPanier(cl);
		} else {
			boolean produitTrouve = false;
			CartLine cartline;
			for (CartLine cl : cart.getlCartLines()) {
				if(cl.getP().getIdProduct() == idProduit) {
					cl.setQty(cl.getQty() + 1);
					produitTrouve = true;
				}
			}
			if(!produitTrouve) {
				cartline = cartlineService.nouvelleCartLine(p.get(), quantite);
				cartService.modifierPanier(cart.getIdCart(), cartline);
			}
		}
		
		s.setAttribute("panier", cart);
	}
}
