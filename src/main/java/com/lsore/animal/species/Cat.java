package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;
import java.util.Optional;

public class Cat extends Animal {

    private final boolean isIndoor;

    public Cat(int uniqueId,
               String animalName,
               AnimalSpecie animalSpecie,
               int animalAge,
               AnimalGender animalGender,
               LocalDate dateOfArrival,
               AdoptionStatus adoptionStatus,
               boolean isIndoor) {
        super(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus);
        this.isIndoor = isIndoor;
    }

    /**
     * Returns whether the cat is an indoor cat.
     * @return Optional of true or false
     */
    public Optional<Boolean> isIndoor() {
        return Optional.of(isIndoor);
    }
}