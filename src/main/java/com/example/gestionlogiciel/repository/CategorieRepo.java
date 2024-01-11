package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}
