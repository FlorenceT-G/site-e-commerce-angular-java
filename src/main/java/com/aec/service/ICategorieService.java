package com.aec.service;

import java.util.ArrayList;
import java.util.Optional;

import com.aec.entity.Categorie;

public interface ICategorieService {
	public void ajoutCategorie(Categorie c);
	public void supprimerCategorie(int id);
	public Optional<Categorie> trouverCategorie(int id);
	public ArrayList<Categorie> listeToutesCategories();
}
