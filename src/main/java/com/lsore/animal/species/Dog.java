package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;
import java.util.Optional;

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
               boolean isTrained,
               int walkFrequency) {
        super(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus);
        this.isTrained = isTrained;
        this.walkFrequency = walkFrequency;
    }

    /**
     * Returns whether the dog is trained.
     * @return Optional of true or false
     */
    public Optional<Boolean> isTrained() {
        return Optional.of(isTrained);
    }

    /**
     * Returns how many times the dog needs to be walked per day.
     * @return Optional of number of daily walks
     */
    public Optional<Integer> getWalkFrequency() {
        return Optional.of(walkFrequency);
    }
}