package com.lsore.shelter;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.storage.AnimalFile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class Shelter {

    private final HashSet<Animal> animals;

    public Shelter() {
        animals = new HashSet<>();
    }

    /**
     * Adds the animal to the HashSet
     * @param animal the animal object to add
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Removes an Animal from the shelter by its unique ID
     * @param uniqueId the unique four-digit ID
     * @return true if found and removed
     */
    public boolean removeAnimal(int uniqueId) {
        return animals.removeIf(animal -> animal.getUniqueId() == uniqueId);
    }

    /**
     * Gets an animal by its unique ID.
     * @param uniqueId the unique four-digit ID
     * @return the animal with the matching ID, or null if none found
     */
    public Animal getAnimalById(int uniqueId) {
        return animals.stream()
                .filter(animal -> animal.getUniqueId() == uniqueId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets a list of animals by their specie.
     * @param animalSpecie the specie to search for
     * @return list of animals matching the specie
     */
    public List<Animal> getAnimalsBySpecie(AnimalSpecie animalSpecie) {
        return animals.stream()
                .filter(animal -> animal.getAnimalSpecie().equals(animalSpecie))
                .toList();
    }

    /**
     * Gets a list of animals by their adoption status.
     * @param adoptionStatus the adoption status to search for
     * @return list of animals matching the adoption status
     */
    public List<Animal> getAnimalsByAdoptionStatus(AdoptionStatus adoptionStatus) {
        return animals.stream()
                .filter(animal -> animal.getAdoptionStatus().equals(adoptionStatus))
                .toList();
    }

    /**
     * Returns all animals in the shelter.
     * @return the animals HashSet
     */
    public HashSet<Animal> getAnimals() {
        return animals;
    }

    /**
     * Counts number of animals by a given adoption status.
     * @param adoptionStatus the adoption status to count
     * @return the count of animals with the given status
     */
    public int getAnimalsCount(AdoptionStatus adoptionStatus) {
        return Math.toIntExact(animals.stream()
                .filter(animal -> animal.getAdoptionStatus().equals(adoptionStatus))
                .count());
    }
}