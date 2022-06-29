package com.aec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aec.entity.Categorie;
import com.aec.entity.Product;

public interface IProductDao extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.cat = :c")
	public List<Product> findProductByCat(@Param("c")Categorie Cat);

}
