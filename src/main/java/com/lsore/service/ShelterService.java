package com.lsore.service;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalSpecie;
import com.lsore.shelter.Shelter;

import java.util.HashSet;
import java.util.List;

public class ShelterService {

    private final Shelter shelter;

    public ShelterService(Shelter shelter) {
        this.shelter = shelter;
    }

    /**
     * Removes an Animal by its unique ID from the shelter
     * @param uniqueId the unique ID of the Animal
     */
    public void removeAnimalById(int uniqueId) {
        shelter.removeAnimal(uniqueId);
    }

    /**
     * Fetches an Animal by its unique ID
     * @param uniqueId the unique ID of the Animal
     * @return the Animal object, or null if not found
     */
    public Animal getAnimalById(int uniqueId) {
        return shelter.getAnimalById(uniqueId);
    }

    /**
     * Adds an Animal to the shelter
     * @param animal the Animal object to add
     */
    public void addAnimal(Animal animal) {
        switch (animal) {
            case Cat cat ->
                    shelter.addAnimal(new Cat(animal.getUniqueId(), animal.getAnimalName(), animal.getAnimalSpecie(), animal.getAnimalAge(), animal.getAnimalGender(), animal.getDateOfArrival(), animal.getAdoptionStatus(), animal.getAnimalDescription(), animal.getAnimalBenefits(), animal.getAnimalDrawbacks(), cat.isIndoor()));
            case Dog dog ->
                    shelter.addAnimal(new Dog(animal.getUniqueId(), animal.getAnimalName(), animal.getAnimalSpecie(), animal.getAnimalAge(), animal.getAnimalGender(), animal.getDateOfArrival(), animal.getAdoptionStatus(), animal.getAnimalDescription(), animal.getAnimalBenefits(), animal.getAnimalDrawbacks(), dog.isTrained(), dog.getWalkFrequency()));
            case null, default -> {
            }
        }
    }

    /**
     * Fetches all Animals with a given specie
     * @param animalSpecie the specie to search for
     * @return list of matching Animals
     */
    public List<Animal> getAnimalsBySpecie(AnimalSpecie animalSpecie) {
        return shelter.getAnimalsBySpecie(animalSpecie);
    }

    /**
     * Fetches all Animals with a given adoption status
     * @param adoptionStatus the status to filter by
     * @return list of matching Animals
     */
    public List<Animal> getAnimalsByAdoptionStatus(AdoptionStatus adoptionStatus) {
        return shelter.getAnimalsByAdoptionStatus(adoptionStatus);
    }

    /**
     * Fetches all Animals in the shelter
     * @return a HashSet of all Animals
     */
    public HashSet<Animal> getAllAnimals() {
        return shelter.getAnimals();
    }

    /**
     * Counts the number of animals with a given adoption status
     * @param adoptionStatus the adoption status
     * @return total count
     */
    public int getAnimalCountByStatus(AdoptionStatus adoptionStatus) {
        return shelter.getAnimalsCount(adoptionStatus);
    }
}