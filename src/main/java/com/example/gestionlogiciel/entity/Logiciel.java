package com.example.gestionlogiciel.entity;




import com.example.gestionlogiciel.keys.LogicielKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Logiciel {


    @EmbeddedId
    LogicielKey logicielKey;

    String description;
    URL url;

    @OneToMany(mappedBy = "logiciel")
    private List<Composant> composants;

    @ManyToMany(mappedBy = "logiciels")
    private List<Application> applications;

    @ManyToOne()
    @JoinColumn(name = "categorie_princ_id")
    @JsonIgnore
    private Categorie categorie_principale;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "categorie_second_id")
    private Categorie categorie_secondaire;

    @ManyToMany()
    @JsonIgnore
    @JoinTable(
            joinColumns =
                    {
                            @JoinColumn(name = "nom_logiciel"),
                            @JoinColumn(name = "version_logiciel")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "nom_licence"),
                            @JoinColumn(name = "version_licence"),
                            @JoinColumn(name = "langue_licence")
                    }
    )
    private List<Licence> licences;

    public Logiciel() {
    }


    public Logiciel(LogicielKey logicielKey, String description, URL url) {
        this.logicielKey = logicielKey;
        this.description = description;
        this.url = url;
    }

    public LogicielKey getLogicielKey() {
        return logicielKey;
    }

    public void setLogicielKey(LogicielKey logicielKey) {
        this.logicielKey = logicielKey;
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


    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public Categorie getCategorie_principale() {
        return categorie_principale;
    }

    public void setCategorie_principale(Categorie categorie_principale) {
        this.categorie_principale = categorie_principale;
    }

    public Categorie getCategorie_secondaire() {
        return categorie_secondaire;
    }

    public void setCategorie_secondaire(Categorie categorie_secondaire) {
        this.categorie_secondaire = categorie_secondaire;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }
}
