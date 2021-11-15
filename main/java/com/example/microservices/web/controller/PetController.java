package com.example.microservices.web.controller;

import com.example.microservices.dao.IPetDAO;
import com.example.microservices.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Controller pour les requêtes http
 */

@RestController
public class PetController {

    @Autowired
    private IPetDAO dao;

    /**
     * Récupérer tous les animaux
     * @return la collection de tous les animaux
     */
    @ResponseBody
    @GetMapping(value = "/Pets")
    public Collection<Pet> getPets(){
        return dao.findAll();
    }

    /**
     * Récupérer un animal
     * @param id identifiant de l'animal à récupérer
     * @return l'animal spécifié par l'identifiant donné
     */
    @ResponseBody
    @GetMapping(value = "/Pets/{id}")
    public Pet getPet(@PathVariable int id){
        return dao.find(id);
    }

    /**
     * Ajout d'un animal
     * @param p animal fourni au travers de l'API
     */
    @PostMapping(value = "Pets")
    public void addPet(@RequestBody Pet p){
        dao.save(p);
    }

    /**
     * Met à jour les informations d'un animal
     * @param id identifiant du profil de l'animal à mettre à jour
     * @param pet nouveau profil de l'aniaml
     * @return Le nouveau profil
     */
    @PutMapping(value = "/Pets/{id}")
    public Pet updateCard(@PathVariable int id, @RequestBody Pet pet) {
        return dao.updateCard(id, pet);
    }

    @DeleteMapping(value = "Pets/{id}")
    public void deletePet(@PathVariable int id){
        dao.deletePet(id);
    }
}
