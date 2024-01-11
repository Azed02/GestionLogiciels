package com.example.gestionlogiciel.keys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;


@Embeddable
public class LogicielKey implements Serializable {
    String nom ;
    @Enumerated(EnumType.ORDINAL)
    Version version;

    public LogicielKey(String nom, Version version) {
        this.nom = nom;
        this.version = version;
    }

    public LogicielKey() {
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
}
