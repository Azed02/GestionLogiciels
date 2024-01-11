package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.controller.ComposantController;
import com.example.gestionlogiciel.entity.Application;
import com.example.gestionlogiciel.entity.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.URL;

public interface CompoRe extends JpaRepository<Application, URL> {
}
