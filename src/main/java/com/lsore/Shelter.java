package com.lsore;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;
import java.util.HashSet;

public class Shelter {

    private final HashSet<Animal> animals;

    public Shelter() {
        animals = new HashSet<>();
    }

    /**
     * Adds animal to the HashSet
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
     * Adds animal to the HashSet
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

    public void addAnimal(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus) {
        animals.add(new Animal(id, name, specie, age, gender, dateOfArrival, adoptionStatus));
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    // Prints information about each animal.
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
            case null -> animals.size();
        };
    }
}
