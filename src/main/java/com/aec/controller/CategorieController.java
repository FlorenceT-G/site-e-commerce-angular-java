package com.aec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aec.entity.Categorie;
import com.aec.service.ICategorieService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CategorieController {
	
	@Autowired
	ICategorieService categorieService;
	
	@GetMapping("/categories")
	public List<Categorie> toutesCategories() {
		return categorieService.listeToutesCategories();
	}
	
	@GetMapping("/categories/{idCat}")
	public Optional<Categorie> getCategorie(@PathVariable("idCat") int idCategorie) {
		return categorieService.trouverCategorie(idCategorie);
	}
	
	@PostMapping("/categories")
	public void insert(@RequestBody Categorie categorie) {
		categorieService.ajoutCategorie(categorie);
	}
	
	@PutMapping("/categories")
	public void modify(@RequestBody Categorie categorie) {
		categorieService.ajoutCategorie(categorie);
	}
	
	@DeleteMapping("/categories/{idCat}")
	public void delete(@PathVariable("idCat") int idCategorie) {
		categorieService.supprimerCategorie(idCategorie);
	}
}
