package com.aec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.IProductDao;
import com.aec.entity.Categorie;
import com.aec.entity.Product;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductDao pDao;
	
	// getters and setters
	public IProductDao getpDao() { return pDao; }
	public void setpDao(IProductDao pDao) { this.pDao = pDao; }
	
	public void nouveauProduit(Product p) {
		pDao.save(p);
	}

	public Optional<Product> trouverProduit(int id) {
		return pDao.findById(id);
	}
	
	public void supprimerProduit(int id) {
		pDao.deleteById(id);
	}
	
	public ArrayList<Product> listeTousProduits() {
		return (ArrayList<Product>) pDao.findAll();
	}
	
	public List<Product> listeProduitsParCategorie(Categorie Cat) {
		return pDao.findProductByCat(Cat);
	}
}
