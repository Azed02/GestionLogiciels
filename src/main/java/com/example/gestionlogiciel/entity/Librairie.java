package com.example.gestionlogiciel.entity;

import com.example.gestionlogiciel.keys.LogicielKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
public class Librairie extends Logiciel {

    public Librairie() {
    }

    public Librairie(LogicielKey logicielKey, String description, URL url) {
        super(logicielKey, description, url);
    }

    @ManyToMany(mappedBy = "librairies")
    private  List<Librairie> librairieList;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "librairies_dependants",
            joinColumns = {
                    @JoinColumn(name = "nom_libraie_dep"),
                    @JoinColumn(name = "version_liraurie_dep")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "nom_librairie"),
                    @JoinColumn(name = "version_librairie")
            }
    )
    private  List<Librairie> librairies;


    public List<Librairie> getLibrairieList() {
        return librairieList;
    }

    public void setLibrairieList(List<Librairie> librairieList) {
        this.librairieList = librairieList;
    }

    public List<Librairie> getLibrairies() {
        return librairies;
    }

    public void setLibrairies(List<Librairie> librairies) {
        this.librairies = librairies;
    }
}
