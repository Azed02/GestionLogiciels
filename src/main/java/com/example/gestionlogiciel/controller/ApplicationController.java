package com.example.gestionlogiciel.controller;


import com.example.gestionlogiciel.entity.Application;
import com.example.gestionlogiciel.entity.Logiciel;
import com.example.gestionlogiciel.keys.LogicielKey;
import com.example.gestionlogiciel.keys.Version;
import com.example.gestionlogiciel.repository.ApplicationRepo;
import com.example.gestionlogiciel.repository.CompoRe;
import com.example.gestionlogiciel.repository.LogicielRepo;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationRepo applicationRepo;
    @Autowired
    CompoRe compoRe;

    @Autowired
    LogicielRepo logicielRepo;

    @GetMapping("/")
    public List<Application> getAllApp(){
        return this.applicationRepo.findAll();
    }

    @GetMapping("/{nom}/{version}/")
    public Application getApplication(@PathVariable String nom, @PathVariable Version version){
        LogicielKey logicielKey  = new LogicielKey(nom,version);
        return this.applicationRepo.findById(logicielKey).get();
    }


    @DeleteMapping("/delete/{nom}/{version}/")
    public void deleteApplication(@PathVariable String nom, @PathVariable Version version){
        LogicielKey logicielKey  = new LogicielKey(nom,version);
        this.applicationRepo.deleteById(logicielKey);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(){
        this.applicationRepo.deleteAll();;
    }

    @PostMapping
    public Application createApp(@RequestBody Application application){
        return this.applicationRepo.save(application);
    }

    @PostMapping("/assign/{nom_lo}/{ver_lo}/to/{nom_app}/{ver_app}")
    public void assignLogiToApp(@PathVariable String nom_lo ,@PathVariable Version ver_lo,@PathVariable String nom_app,@PathVariable Version ver_app){
        LogicielKey logicielKey = new LogicielKey(nom_lo,ver_lo);
        LogicielKey appliKey = new LogicielKey(nom_app,ver_app);

        Optional<Logiciel> logicielOptional = this.logicielRepo.findById(logicielKey);
        Optional<Application> applicationOptional  = this.applicationRepo.findById(appliKey);
        if(logicielOptional.isPresent()&&applicationOptional.isPresent()){
            Logiciel logiciel = logicielOptional.get();
            Application application = applicationOptional.get();
            List<Application> apps = logiciel.getApplications();
            if(apps==null){
                apps= new ArrayList<>();
            }
            apps.add(application);
            logiciel.setApplications(apps);
            this.logicielRepo.save(logiciel);
            List<Logiciel> logiciels = application.getLogiciels();
            if(logiciels==null){
                logiciels = new ArrayList<>();
            }
            logiciels.add(logiciel);
            application.setLogiciels(logiciels);
            this.applicationRepo.save(application);
        }
    }


   /* @GetMapping("/{url}")
    public Application getByID(@PathVariable URL url){
        return this.compoRe.findById(url).get();
    }
*/


}
