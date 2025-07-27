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
     *
     * @param uniqueId      random four digit ID
     * @param animalName    the name of the animal
     * @param animalSpecie  the specie of the animal
     * @param animalAge     the age of the animal
     * @param animalGender  the gender of the animal
     * @param dateOfArrival the date of arrival at the shelter
     * @param adoptionStatus the adoption status of the animal (e.g. AVAILABLE, RESERVED or ADOPTED)
     * @param isIndoor     if the cat is an indoor cat
     */
    public void addAnimal(int uniqueId, String animalName, AnimalSpecie animalSpecie, int animalAge,
                          AnimalGender animalGender, LocalDate dateOfArrival,
                          AdoptionStatus adoptionStatus, boolean isIndoor) {
        animals.add(new Cat(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus, isIndoor));
    }

    /**
     * Adds the animal to the HashSet
     *
     * @param uniqueId      random four digit ID
     * @param animalName    the name of the animal
     * @param animalSpecie  the specie of the animal
     * @param animalAge     the age of the animal
     * @param animalGender  the gender of the animal
     * @param dateOfArrival the date of arrival at the shelter
     * @param adoptionStatus the adoption status of the animal (e.g. AVAILABLE, RESERVED or ADOPTED)
     * @param isTrained    if the dog is trained
     * @param walkFrequency number of daily walks preferred by the animal
     */
    public void addAnimal(int uniqueId, String animalName, AnimalSpecie animalSpecie, int animalAge,
                          AnimalGender animalGender, LocalDate dateOfArrival,
                          AdoptionStatus adoptionStatus, boolean isTrained, int walkFrequency) {
        animals.add(new Dog(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus, isTrained, walkFrequency));
    }

    /**
     * Adds the animal to the HashSet
     *
     * @param animal the animal object to add
     */
    public void addAnimal(Animal animal) {
        // TODO: Consider persisting to file in the future
        AnimalFile animalFile = new AnimalFile();
        animals.add(animal);
    }

    /**
     * Removes an animal from the animals HashSet by its unique ID.
     * Prints an error message if no animal with the ID is found.
     *
     * @param uniqueId the unique ID of the animal to remove
     */
    public void removeAnimal(int uniqueId) {
        boolean removed = animals.removeIf(animal -> animal.getUniqueId() == uniqueId);
        if (!removed) System.err.println("No animal found in the shelter with ID " + uniqueId);
    }

    /**
     * Gets an animal by its unique ID.
     *
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
     *
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
     *
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
     *
     * @return the animals HashSet
     */
    public HashSet<Animal> getAnimals() {
        return animals;
    }

    /**
     * Counts number of animals by a given adoption status.
     *
     * @param adoptionStatus the adoption status to count
     * @return the count of animals with the given status
     */
    public int getAnimalsCount(AdoptionStatus adoptionStatus) {
        return Math.toIntExact(animals.stream()
                .filter(animal -> animal.getAdoptionStatus().equals(adoptionStatus))
                .count());
    }
}