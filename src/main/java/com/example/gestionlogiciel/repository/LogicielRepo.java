package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Logiciel;
import com.example.gestionlogiciel.keys.LogicielKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.URL;

public interface LogicielRepo extends JpaRepository<Logiciel, LogicielKey> {

    public Logiciel findByUrl(URL url);
}
