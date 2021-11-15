package com.example.microservices.dao;

import com.example.microservices.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * DAO des profils d'animaux, permet de récupérer les données enregistrées
 */

@Repository
public class PetDAO implements IPetDAO{

    private Map<Integer, Pet> allPets;

    /**
     * Constructeur du DAO
     * Crée 3 animaux
     */
    public PetDAO() {
        allPets = new HashMap<>();
        allPets.put(0, new Pet("Malo", "Dog", 6));
        allPets.put(1, new Pet("Pschiit", "Cat", 2));
        allPets.put(2, new Pet("Pilou", "Cat", 2));
    }

    /**
     * @return la liste de tous les animaux enregistrées
     */
    @Override
    public Collection<Pet> findAll() {
        return allPets.values();
    }

    /**
     * @param id identifiant de l'animal recherché
     * @return le profil de l'animal concerné par l'identifiant
     */
    @Override
    public Pet find(int id) {
        return allPets.get(id);
    }

    /**
     * Enregistre un nouvel animal à la base de données
     * @param pet nouvel animal à enregistrer
     */
    @Override
    public void save(Pet pet) {
        allPets.put(pet.getId(), pet);
    }
}
