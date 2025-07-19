package com.lsore.animal.species;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;

public class Cat extends Animal {

    private final boolean isIndoor;

    public Cat(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus, boolean isIndoor) {
        super(id, name, specie, age, gender, dateOfArrival, adoptionStatus);
        this.isIndoor = isIndoor;
    }

    /**
     * Returns True or False depending on if the cat is an indoor cat.
     * @return true or false
     */
    public boolean isIndoor() {
        return isIndoor;
    }
}
