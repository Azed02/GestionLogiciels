package com.example.gestionlogiciel.keys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;


@Embeddable
public class LicenceKey implements Serializable {
    String nom;
    @Enumerated(EnumType.ORDINAL)
    Version version;

    String Langue;

    public LicenceKey(String nom, Version version, String langue) {
        this.nom = nom;
        this.version = version;
        Langue = langue;
    }

    public LicenceKey() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String langue) {
        Langue = langue;
    }
}
