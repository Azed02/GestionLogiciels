package com.example.gestionlogiciel.entity;

import com.example.gestionlogiciel.keys.ComposantKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
public class Composant {
    @EmbeddedId
    ComposantKey composantKey;
     String description;
     URL url;

     @ManyToOne
     @JsonIgnore
     @JoinColumns({
             @JoinColumn(name = "logciciel_nom"),
             @JoinColumn(name = "logiciel_version")
     })
     private Logiciel logiciel;



     @ManyToMany()
     @JoinTable(
             name = "composants_licences",
             joinColumns = {
                     @JoinColumn(name = "composant_code"),
                     @JoinColumn(name = "composant_version")
             },
             inverseJoinColumns = {
                     @JoinColumn(name = "licence_nom"),
                     @JoinColumn(name = "licence_Version"),
                     @JoinColumn(name = "licence_langue")
             }
     )
     private List<Licence> licences;

    public Composant(ComposantKey composantKey, String description, URL url) {
        this.composantKey = composantKey;
        this.description = description;
        this.url = url;
    }

    public Composant() {
    }

    public ComposantKey getComposantKey() {
        return composantKey;
    }

    public void setComposantKey(ComposantKey composantKey) {
        this.composantKey = composantKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Logiciel getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(Logiciel logiciel) {
        this.logiciel = logiciel;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }
}
