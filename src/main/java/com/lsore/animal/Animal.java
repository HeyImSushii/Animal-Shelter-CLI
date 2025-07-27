package com.lsore.animal;

import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;

public class Animal {

    private int uniqueId;
    private String animalName;
    private AnimalSpecie animalSpecie;
    private int animalAge;
    private AnimalGender animalGender;
    private LocalDate dateOfArrival;
    private AdoptionStatus adoptionStatus;

    public Animal(int uniqueId, String animalName, AnimalSpecie animalSpecie, int animalAge, AnimalGender animalGender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus) {
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.animalSpecie = animalSpecie;
        this.animalAge = animalAge;
        this.animalGender = animalGender;
        this.dateOfArrival = dateOfArrival;
        this.adoptionStatus = adoptionStatus;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public AnimalSpecie getAnimalSpecie() {
        return animalSpecie;
    }

    public void setAnimalSpecie(AnimalSpecie animalSpecie) {
        this.animalSpecie = animalSpecie;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public AnimalGender getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(AnimalGender animalGender) {
        this.animalGender = animalGender;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public AdoptionStatus getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }
}