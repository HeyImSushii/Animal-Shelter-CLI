package com.lsore.shelter;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

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
     * @param id random four digit ID
     * @param name the name of the animal
     * @param specie the specie of the animal
     * @param age the age of the animal
     * @param gender the gender of the animal
     * @param dateOfArrival the date of arrival at the shelter
     * @param status the adoption status of the animal (e.g. AVAILABLE, RESERVED or ADOPTED)
     * @param isIndoor if the cat is an indoor cat
     */
    public void addAnimal(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus status, boolean isIndoor) {
        animals.add(new Cat(id, name, specie, age, gender, dateOfArrival, status, isIndoor));
    }

    /**
     * Adds the animal to the HashSet
     *
     * @param id random four digit ID
     * @param name the name of the animal
     * @param specie the specie of the animal
     * @param age the age of the animal
     * @param gender the gender of the animal
     * @param dateOfArrival the date of arrival at the shelter
     * @param status the adoption status of the animal (e.g. AVAILABLE, RESERVED or ADOPTED)
     * @param isTrained if the dog is trained
     * @param walkFrequency number of daily walks preferred by the animal
     */
    public void addAnimal(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus status, boolean isTrained, int walkFrequency) {
        animals.add(new Dog(id, name, specie, age, gender, dateOfArrival, status, isTrained, walkFrequency));
    }

    /**
     * Adds the animal to the HashSet
     * @param animal the animal object
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Removes an animal from the Animals HashSet, by its ID.
     * @param id the unique ID of the animal
     */
    public void removeAnimal(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animals.remove(animal);
                return;
            }
        }
        System.err.println("There is no animals in the shelter with ID " + id);
    }

    /**
     * Prints information about the animal.
     * NOTE: Will be deprecated in the future.
     */
    public void listAnimals() {
        getAnimals().forEach(animal -> {
            if (animal instanceof Cat) {
                System.out.println("ID: " + animal.getId());
                System.out.println("Name: " + animal.getName());
                System.out.println("Specie: " + animal.getSpecie());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Gender: " + animal.getGender());
                System.out.println("Date of Arrival: " + animal.getDateOfArrival());
                System.out.println("Adoption Status: " + animal.getAdoptionStatus());
                System.out.println("isIndoor: " + ((Cat) animal).isIndoor());
                System.out.println("\n");
            }
            if (animal instanceof Dog) {
                System.out.println("ID: " + animal.getId());
                System.out.println("Name: " + animal.getName());
                System.out.println("Specie: " + animal.getSpecie());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Gender: " + animal.getGender());
                System.out.println("Date of Arrival: " + animal.getDateOfArrival());
                System.out.println("Adoption Status: " + animal.getAdoptionStatus());
                System.out.println("isTrained: " + ((Dog) animal).isTrained());
                System.out.println("walkFrequency: " + ((Dog) animal).getWalkFrequency());
                System.out.println("\n");
            }
        });
    }

    /**
     * Gets an animal by its unique iD
     * @param id the unique four-digit id
     * @return the requested animal
     */
    public Animal getAnimalById(int id) {
        return animals.stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);
    }

    /**
     * Gets animals by specie
     * @param specie the specie to search for
     * @return list of animals by specie
     */
    public List<Animal> getAnimalsBySpecie(AnimalSpecie specie) {
       return animals.stream().filter(animal -> animal.getSpecie().equals(specie)).toList();
    }

    /**
     * Gets animals by adoption status
     * @param status the adoption status to search for
     * @return list of animals by adoption status
     */
    public List<Animal> getAnimalsByAdoptionStatus(AdoptionStatus status) {
        return animals.stream().filter(animal -> animal.getAdoptionStatus().equals(status)).toList();
    }

    /**
     * Returns the animals in the HashSet as elements
     * @return the animals in the HashSet
     */
    public HashSet<Animal> getAnimals() {
        return animals;
    }

    /**
     * Counts number of animals by status
     * @param adoptionStatus the adoption status
     * @return the number of animals by status
     */
    public int getAnimalsCount(AdoptionStatus adoptionStatus) {
        return switch (adoptionStatus) {
            case AVAILABLE ->
                    Math.toIntExact(animals.stream().filter(animal -> animal.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE)).count());
            case RESERVED ->
                    Math.toIntExact(animals.stream().filter(animal -> animal.getAdoptionStatus().equals(AdoptionStatus.RESERVED)).count());
            case ADOPTED ->
                    Math.toIntExact(animals.stream().filter(animal -> animal.getAdoptionStatus().equals(AdoptionStatus.ADOPTED)).count());
        };
    }
}
