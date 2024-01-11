package com.example.gestionlogiciel.controller;

import com.example.gestionlogiciel.entity.Categorie;
import com.example.gestionlogiciel.entity.Logiciel;
import com.example.gestionlogiciel.keys.LogicielKey;
import com.example.gestionlogiciel.keys.Version;
import com.example.gestionlogiciel.repository.CategorieRepo;
import com.example.gestionlogiciel.repository.LogicielRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/logiciel")
public class LogicielController {

    @Autowired
    LogicielRepo logicielRepo;

    @Autowired
    CategorieRepo categorieRepo;


    @GetMapping("/")
    public List<Logiciel> getAllLogi(){
        return this.logicielRepo.findAll();
    }

    @GetMapping("/{nom}/{version}")
    public Logiciel getLogiciel(@PathVariable String nom, @PathVariable Version version){
        LogicielKey logicielKey =new LogicielKey(nom,version);
        return this.logicielRepo.findById(logicielKey).get();
    }

    @GetMapping("/search")
    public Logiciel searchLogiciel(@RequestParam URL url ){
        return this.logicielRepo.findByUrl(url);
    }

    @PostMapping
    public Logiciel addLogiciel(@RequestBody Logiciel logiciel){
        return this.logicielRepo.save(logiciel);
    }

    @DeleteMapping("/{nom}/{version}")
    public void deleteLogiciel(@PathVariable String nom,@PathVariable Version version){
        LogicielKey logicielKey = new LogicielKey(nom,version);
        this.logicielRepo.deleteById(logicielKey);
    }

    @PostMapping("/{nom_lo}/{ver_lo}/princ/to/{id}")
    public void assignCategoriTOLogi(@PathVariable String nom_lo,@PathVariable Version ver_lo,@PathVariable Long id){
        LogicielKey logicielKey = new LogicielKey(nom_lo,ver_lo);
        Logiciel logiciel = this.logicielRepo.findById(logicielKey).get();
        Categorie categorie = this.categorieRepo.findById(id).get();
        if(logiciel != null && categorie != null){
           List<Logiciel> logiciels =  categorie.getLogiciels();
           logiciels.add(logiciel);
           categorie.setLogiciels(logiciels);
           logiciel.setCategorie_principale(categorie);
           this.logicielRepo.save(logiciel);
           this.categorieRepo.save(categorie);
        }

    }


    @PostMapping("/{nom_lo}/{ver_lo}/secon/to/{id}")
    public void assignSeconCategoriTOLogi(@PathVariable String nom_lo,@PathVariable Version ver_lo,@PathVariable Long id){
        LogicielKey logicielKey = new LogicielKey(nom_lo,ver_lo);
        Logiciel logiciel = this.logicielRepo.findById(logicielKey).get();
        Categorie categorie = this.categorieRepo.findById(id).get();
        if(logiciel != null && categorie != null){
            List<Logiciel> logiciels =  categorie.getLogiciels();
            logiciels.add(logiciel);
            categorie.setLogiciels(logiciels);
            logiciel.setCategorie_secondaire(categorie);
            this.logicielRepo.save(logiciel);
            this.categorieRepo.save(categorie);
        }

    }
}
