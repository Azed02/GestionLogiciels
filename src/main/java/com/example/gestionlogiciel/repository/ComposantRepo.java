package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Composant;
import com.example.gestionlogiciel.keys.ComposantKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepo extends JpaRepository<Composant, ComposantKey> {
}
