package com.aec.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.dao.ICategorieDao;
import com.aec.entity.Categorie;

@Service
public class CategorieService implements ICategorieService {
	
	@Autowired
	ICategorieDao iCatDao;
	
	// getters and setters
	public ICategorieDao getiCatDao() { return iCatDao; }
	public void setiCatDao(ICategorieDao iCatDao) { this.iCatDao = iCatDao; }
	
	public void ajoutCategorie(Categorie c) {
		iCatDao.save(c);
	}
	
	public void supprimerCategorie(int id) {
		iCatDao.deleteById(id);
	}
	
	public Optional<Categorie> trouverCategorie(int id) {
		return iCatDao.findById(id);
	}
	
	public ArrayList<Categorie> listeToutesCategories() {
		ArrayList<Categorie> lc = (ArrayList<Categorie>)iCatDao.findAll();
		return lc;
	}
}
