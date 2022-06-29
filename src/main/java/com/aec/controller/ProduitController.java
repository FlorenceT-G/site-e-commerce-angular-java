package com.aec.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aec.entity.Categorie;
import com.aec.entity.Product;
import com.aec.service.ICategorieService;
import com.aec.service.IProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProduitController {

	@Autowired
	IProductService productService;
	
	@Autowired
	ICategorieService categorieService;
	
	@GetMapping("/produits")
	public List<Product> tousProduits() {
		return productService.listeTousProduits();
	}
	
	@GetMapping("/produits/{idCat}")
	public List<Product> parCategories(@PathVariable("idCat") int idCategorie) {
		Optional<Categorie> categorie = categorieService.trouverCategorie(idCategorie);
		return productService.listeProduitsParCategorie(categorie.get());
	}
	
	@PostMapping("/produits")
	public void insert(@ModelAttribute Product produit, HttpSession session) {
		System.out.println(produit.getLabelProduct());
		
		//Optional<Categorie> categorie = categorieService.trouverCategorie(idCat);
		//produit.setCat(categorie.get());
		
		productService.nouveauProduit(produit);
	}
	
	@PostMapping("/produits/uploadFile")
	public void uploadFIle(@RequestParam("File") MultipartFile file) {
		String path = "/home/florence/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/AEC_API/src/main/resources/static";
		String filename = "img/products/"+ file.getOriginalFilename();
		
		try {
			byte barr[] = file.getBytes();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/produits")
	public void modify(@ModelAttribute Product produit) {
		productService.nouveauProduit(produit);
	}
	
	@DeleteMapping("/produits/{idProd}")
	public void delete(@PathVariable("idProd") int idProduit) {
		productService.supprimerProduit(idProduit);
	}
	
}
