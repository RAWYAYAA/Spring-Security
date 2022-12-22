package com.springsecurityfirstproject.controllers;


import com.springsecurityfirstproject.entities.Produit;
import com.springsecurityfirstproject.services.ServicesImpl.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@RestController
public class ProduitController {
    @Autowired
    ProduitService produitService;


    @PostMapping(value = "/saveProduit")
    public Produit saveCommand(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @GetMapping("/fetchCommande")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PutMapping("/produit/{id}")
    public Produit updateCommande(@RequestBody Produit produit, @PathVariable("id") Long id) {
        return produitService.update(produit, id);
    }

    @DeleteMapping("/deleteProduit/{id}")
    public String deleteProduitById(@PathVariable("id") Long id) {
        produitService.delete(id);
        return "Deleted Successfully";
    }

}
