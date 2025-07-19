package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;

public class Dog extends Animal {

    private final boolean isTrained;
    private final int walkFrequency;

    public Dog(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus, boolean isTrained, int walkFrequency) {
        super(id, name, specie, age, gender, dateOfArrival, adoptionStatus);
        this.isTrained = isTrained;
        this.walkFrequency = walkFrequency;
    }

    /**
     * Returns True or False depending on if the animal is trained
     * @return true or false
     */
    public boolean isTrained() {
        return isTrained;
    }

    /**
     * The number of daily walks the animal requires
     * @return number of daily walks as an integer
     */
    public int getWalkFrequency() {
        return walkFrequency;
    }
}
