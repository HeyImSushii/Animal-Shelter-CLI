package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Animal {

    private final boolean isTrained;
    private final int walkFrequency;

    public Dog(int uniqueId,
               String animalName,
               AnimalSpecie animalSpecie,
               int animalAge,
               AnimalGender animalGender,
               LocalDate dateOfArrival,
               AdoptionStatus adoptionStatus,
               String[] animalDescription,
               List<String> animalBenefits,
               List<String> animalDrawbacks,
               boolean isTrained,
               int walkFrequency) {
        super(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus, animalDescription, animalBenefits, animalDrawbacks);
        this.isTrained = isTrained;
        this.walkFrequency = walkFrequency;
    }

    /**
     * Returns whether the dog is trained.
     * @return True or False
     */
    public boolean isTrained() {
        return isTrained;
    }

    /**
     * Returns how many times the dog needs to be walked per day.
     * @return Number of daily walks
     */
    public int getWalkFrequency() {
        return walkFrequency;
    }
}