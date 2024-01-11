package com.example.gestionlogiciel.repository;

import com.example.gestionlogiciel.entity.Licence;
import com.example.gestionlogiciel.keys.LicenceKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenceREpository extends JpaRepository<Licence, LicenceKey> {
}
