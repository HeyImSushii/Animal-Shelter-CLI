package com.lsore.controller;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalSpecie;
import com.lsore.service.ShelterService;

import java.util.List;

public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    /**
     * Adds an Animal to the shelter
     * @param animal the animal object
     */
    public void addAnimal(Animal animal) {
        shelterService.addAnimal(animal);
    }

    /**
     * Adds a Cat Animal to the shelter
     * @param cat The cat object
     */
    public void addAnimal(Cat cat) {
        shelterService.addAnimal(cat);
    }

    /**
     * Adds a Dog Animal to the shelter
     * @param dog The dog object
     */
    public void addAnimal(Dog dog) {
        shelterService.addAnimal(dog);
    }

    /**
     * Removes an Animal from the shelter by its unique ID
     * @param uniqueId the unique ID to look for
     */
    public void removeAnimal(int uniqueId) {
        shelterService.removeAnimalById(uniqueId);
    }

    /**
     * Fetches all the Animals
     * @return the Animals as a HashSet
     */
    public List<Animal> getAnimals() {
        return shelterService.getAllAnimals();
    }

    /**
     * Fetches an Animal by its unique ID
     * @param uniqueId the unique ID to look for
     * @return the Animal as an object
     */
    public Animal getAnimalByUniqueId(int uniqueId) {
        return shelterService.getAnimalById(uniqueId);
    }

    /**
     * Fetches a list of Animals based on its specie
     * @param animalSpecie the specie to look for
     * @return a list of Animals by the specified specie
     */
    public List<Animal> getAnimalsBySpecie(AnimalSpecie animalSpecie) {
        return shelterService.getAnimalsBySpecie(animalSpecie);
    }

    /**
     * Fetches a list of Animals based on its adoption status
     * @param adoptionStatus the status to look for
     * @return a list of Animals by the specified adoption status
     */
    public List<Animal> getAnimalsByAdoptionStatus(AdoptionStatus adoptionStatus) {
        return shelterService.getAnimalsByAdoptionStatus(adoptionStatus);
    }

    /**
     * Returns an integer value based on the number of Animals by adoption status
     * @param adoptionStatus the status to look for
     * @return number of animals by status as an integer
     */
    public int getAnimalCountByStatus(AdoptionStatus adoptionStatus) {
        return shelterService.getAnimalCountByStatus(adoptionStatus);
    }
}
