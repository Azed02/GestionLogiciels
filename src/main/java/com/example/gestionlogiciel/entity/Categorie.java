package com.example.gestionlogiciel.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;



    public Categorie() {

    }
    public Categorie( String nom) {
        this.nom = nom;
    }


    @OneToMany(mappedBy = "categorie_principale")
    private List<Logiciel> logicielList;

    @OneToMany(mappedBy = "categorie_secondaire")
    private List<Logiciel> logiciels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Logiciel> getLogicielList() {
        return logicielList;
    }

    public void setLogicielList(List<Logiciel> logicielList) {
        this.logicielList = logicielList;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }
}
