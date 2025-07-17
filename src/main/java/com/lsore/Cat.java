package com.lsore;

import java.time.LocalDate;

public class Cat extends Animal {

    private final boolean isIndoor;

    public Cat(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus, boolean isIndoor) {
        super(id, name, specie, age, gender, dateOfArrival, adoptionStatus);
        this.isIndoor = isIndoor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }
}
