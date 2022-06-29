package com.aec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aec.entity.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Integer> {

}
