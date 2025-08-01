package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;

public class Cat extends Animal {

    private final boolean isIndoor;

    public Cat(int uniqueId,
               String animalName,
               AnimalSpecie animalSpecie,
               int animalAge,
               AnimalGender animalGender,
               LocalDate dateOfArrival,
               AdoptionStatus adoptionStatus,
               String[] animalDescription,
               String[] animalBenefits,
               String[] animalDrawbacks,
               boolean isIndoor) {
        super(uniqueId, animalName, animalSpecie, animalAge, animalGender, dateOfArrival, adoptionStatus, animalDescription, animalBenefits, animalDrawbacks);
        this.isIndoor = isIndoor;
    }

    /**
     * Returns whether the cat is an indoor cat.
     * @return Optional of true or false
     */
    public boolean isIndoor() {
        return isIndoor;
    }
}