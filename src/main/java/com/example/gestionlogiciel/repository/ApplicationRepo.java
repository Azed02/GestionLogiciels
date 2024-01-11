package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Application;
import com.example.gestionlogiciel.keys.LogicielKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, LogicielKey> {
}
