package com.example.gestionlogiciel.entity;


import com.example.gestionlogiciel.keys.LogicielKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity

public class Application extends Logiciel{


    @Id
    @Column(nullable = false,unique = true)
    private URL url = super.getUrl();

    public Application() {
    }
    public Application(LogicielKey logicielKey, String description, URL url) {
        super(logicielKey, description, url);
    }

    @ManyToMany()
    @JsonIgnore
    @JoinTable(
            joinColumns ={
                    @JoinColumn(name = "application_nom"),
                    @JoinColumn(name = "application_Version")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "logiciels_nom"),
                    @JoinColumn(name = "logiciels_Version")
            }
    )
    private List<Logiciel> logiciels;

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public void setUrl(URL url) {
        this.url = url;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }
}
