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

    @ResponseBody
    @GetMapping(value = "/Pets")
    public Collection<Pet> getPets(){
        return dao.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/Pets/{id}")
    public Pet getPet(@PathVariable int id){
        return dao.find(id);
    }

    @PostMapping(value = "Pets")
    public void addPet(@RequestBody Pet p){
        dao.save(p);
    }
}
