package com.example.gestionlogiciel.controller;

import com.example.gestionlogiciel.entity.Composant;
import com.example.gestionlogiciel.entity.Logiciel;
import com.example.gestionlogiciel.keys.ComposantKey;
import com.example.gestionlogiciel.keys.LogicielKey;
import com.example.gestionlogiciel.keys.Version;
import com.example.gestionlogiciel.repository.ComposantRepo;
import com.example.gestionlogiciel.repository.LogicielRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composant")
public class ComposantController {
    @Autowired
    ComposantRepo composantRepo;

    @Autowired
    LogicielRepo logicielRepo;

    @GetMapping("/")
    public List<Composant> getAllComposant(){
        return this.composantRepo.findAll();
    }

    @GetMapping("/{code}/{version}")
    public Composant getComposant(@PathVariable String code, @PathVariable Version version){
        ComposantKey composantKey = new ComposantKey(code,version);
        return  this.composantRepo.findById(composantKey).get();
    }

    @PostMapping
    public Composant addComposant(@RequestBody Composant composant){
        return this.composantRepo.save(composant);
    }

    @PostMapping("/{code}/{version}/to/{nom_lo}/{version_lo}")
    public void assignCompoToLogi(@PathVariable String code,@PathVariable Version version,@PathVariable String  nom_lo , @PathVariable Version version_lo){
        ComposantKey composantKey  = new ComposantKey( code, version);
        LogicielKey logicielKey = new LogicielKey(nom_lo,version_lo);
        Composant composant = this.composantRepo.findById(composantKey).get();
        Logiciel logiciel  = this.logicielRepo.findById(logicielKey).get();
        List<Composant> composants = logiciel.getComposants();
        composants.add(composant);
        logiciel.setComposants(composants);
        composant.setLogiciel(logiciel);
        this.composantRepo.save(composant);
        this.logicielRepo.save(logiciel);
    }


}
