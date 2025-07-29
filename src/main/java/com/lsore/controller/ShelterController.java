package com.lsore.controller;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalSpecie;
import com.lsore.service.ShelterService;

import java.util.HashSet;
import java.util.List;

public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    // Adds a Cat Animal tot the shelter
    public void addAnimal(Cat cat) {
        shelterService.addAnimal(cat);
    }

    // Adds a Dog Animal to the shelter
    public void addAnimal(Dog dog) {
        shelterService.addAnimal(dog);
    }

    public boolean removeAnimal(int uniqueId) {
        return shelterService.removeAnimalById(uniqueId);
    }

    public HashSet<Animal> getAnimals() {
        return shelterService.getAllAnimals();
    }

    public List<Animal> getAnimalsBySpecie(AnimalSpecie animalSpecie) {
        return shelterService.getAllAnimals().stream()
                .filter(animal -> animal.getAnimalSpecie().equals(animalSpecie))
                .toList();
    }

    public List<Animal> getAnimalsByAdoptionStatus(AdoptionStatus adoptionStatus) {
        return shelterService.getAllAnimals().stream()
                .filter(animal -> animal.getAdoptionStatus().equals(adoptionStatus))
                .toList();
    }

    public int getAnimalCountByStatus(AdoptionStatus adoptionStatus) {
        return shelterService.getAnimalCountByStatus(adoptionStatus);
    }
}
