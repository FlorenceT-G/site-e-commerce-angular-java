package com.aec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aec.entity.Categorie;
import com.aec.entity.Product;

public interface IProductService {

	public void nouveauProduit(Product p);
	public void supprimerProduit(int id);
	public ArrayList<Product> listeTousProduits();
	public List<Product> listeProduitsParCategorie(Categorie Cat);
	public Optional<Product> trouverProduit(int id);
}
