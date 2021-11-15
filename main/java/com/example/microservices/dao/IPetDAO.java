package com.example.microservices.dao;

import com.example.microservices.model.Pet;

import java.util.Collection;

/**
 * Interface du DAO pour gérer les profils d'animaux
 */

public interface IPetDAO {

    Collection<Pet> findAll();
    Pet find(int id);
    void save(Pet pet);
    Pet updateCard(int   id, Pet pet);
    void deletePet(int id);
}
