package com.example.gestionlogiciel.entity;

import com.example.gestionlogiciel.keys.LicenceKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.hibernate.type.descriptor.java.ClobJavaType;

import java.sql.Clob;
import java.util.List;

@Entity
public class Licence {
    @EmbeddedId
    LicenceKey licenceKey;
    private ClobJavaType texte;


    @ManyToMany(mappedBy = "licences")
    @JsonIgnore
    private List<Logiciel> logiciels;

    @ManyToMany(mappedBy = "licences")
    @JsonIgnore
    private List<Composant> composants;

    public Licence(LicenceKey licenceKey, ClobJavaType texte) {
        this.licenceKey = licenceKey;
        this.texte = texte;
    }

    public Licence() {
    }

    public LicenceKey getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(LicenceKey licenceKey) {
        this.licenceKey = licenceKey;
    }

    public ClobJavaType getTexte() {
        return texte;
    }

    public void setTexte(ClobJavaType texte) {
        this.texte = texte;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }
}
