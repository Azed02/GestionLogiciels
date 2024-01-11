package com.example.gestionlogiciel.controller;


import com.example.gestionlogiciel.entity.Composant;
import com.example.gestionlogiciel.entity.Licence;
import com.example.gestionlogiciel.entity.Logiciel;
import com.example.gestionlogiciel.keys.ComposantKey;
import com.example.gestionlogiciel.keys.LicenceKey;
import com.example.gestionlogiciel.keys.LogicielKey;
import com.example.gestionlogiciel.keys.Version;
import com.example.gestionlogiciel.repository.ComposantRepo;
import com.example.gestionlogiciel.repository.LicenceREpository;
import com.example.gestionlogiciel.repository.LogicielRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licensce")
public class LicenceController {
    @Autowired
    LicenceREpository licenceREpository;
    @Autowired
    LogicielRepo logicielRepo;

    @Autowired
    ComposantRepo composantRepo;

    @GetMapping
    public List<Licence> getAllLicende(){
        return this.licenceREpository.findAll();
    }

    @GetMapping("/{nom}/{verion}/{lang}")
    public Licence getLicence(@PathVariable String nom, @PathVariable Version verion,@PathVariable String lang){
        LicenceKey licenceKey = new LicenceKey(nom,verion,lang);
        return this.licenceREpository.findById(licenceKey).get();
    }
    @PostMapping
    public Licence addLicence(@RequestBody Licence licence){
        return this.licenceREpository.save(licence);
    }

    @DeleteMapping("/{nom}/{vers}/{lang}")
    public void search(@PathVariable String nom,@PathVariable Version vers,@PathVariable String lang){
        LicenceKey licenceKey = new LicenceKey(nom,vers,lang);
        this.licenceREpository.deleteById(licenceKey);
    }

    @PostMapping("/{nom_lo}/{vers_lo}/to/{nom}/{vers}/{lang}")
    public void attacherLogitoLicence(@PathVariable String nom_lo,@PathVariable Version vers_lo,@PathVariable String nom,@PathVariable Version vers,@PathVariable String lang){
        LogicielKey logicielKey = new LogicielKey(nom_lo, vers_lo);
        LicenceKey licenceKey = new LicenceKey(nom,vers,lang);
        Logiciel logiciel = this.logicielRepo.findById(logicielKey).get();
        Licence licence = this.licenceREpository.findById(licenceKey).get();
        List<Licence> licences  = logiciel.getLicences();
        licences.add(licence);
        logiciel.setLicences(licences);
        List<Logiciel> logiciels = licence.getLogiciels();
        logiciels.add(logiciel);
        licence.setLogiciels(logiciels);
        this.licenceREpository.save(licence);
        this.logicielRepo.save(logiciel);

    }


    @PostMapping("/composant/{code_co}/{vers_co}/to/{nom}/{vers}/{lang}")
    public void attacheCompotoLic(@PathVariable String code_co,@PathVariable Version vers_co,@PathVariable String nom,@PathVariable Version vers,@PathVariable String lang){
        ComposantKey composantKey = new ComposantKey(code_co,vers_co);
        LicenceKey licenceKey = new LicenceKey(nom,vers,lang);
        Licence licence = this.licenceREpository.findById(licenceKey).get();
        Composant composant = this.composantRepo.findById(composantKey).get();
        List<Composant> composants = licence.getComposants();
        composants.add(composant);
        licence.setComposants(composants);
        List<Licence> licences = composant.getLicences();
        licences.add(licence);
        composant.setLicences(licences);
        this.licenceREpository.save(licence);
        this.composantRepo.save(composant);

    }




}
