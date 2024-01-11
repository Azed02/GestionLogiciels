package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Librairie;
import com.example.gestionlogiciel.keys.LogicielKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrairieRepo extends JpaRepository<Librairie, LogicielKey> {
}
