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
    private String[] animalDescription;
    private String[] animalBenefits;
    private String[] animalDrawbacks;

    public Animal(int uniqueId,
                  String animalName,
                  AnimalSpecie animalSpecie,
                  int animalAge,
                  AnimalGender animalGender,
                  LocalDate dateOfArrival,
                  AdoptionStatus adoptionStatus,
                  String[] animalDescription,
                  String[] animalBenefits,
                  String[] animalDrawbacks) {
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.animalSpecie = animalSpecie;
        this.animalAge = animalAge;
        this.animalGender = animalGender;
        this.dateOfArrival = dateOfArrival;
        this.adoptionStatus = adoptionStatus;
        this.animalDescription = animalDescription;
        this.animalBenefits = animalBenefits;
        this.animalDrawbacks = animalDrawbacks;

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

    public String[] getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String[] animalDescription) {
        this.animalDescription = animalDescription;
    }

    public String[] getAnimalBenefits() {
        return animalBenefits;
    }

    public void setAnimalBenefits(String[] animalBenefits) {
        this.animalBenefits = animalBenefits;
    }

    public String[] getAnimalDrawbacks() {
        return animalDrawbacks;
    }

    public void setAnimalDrawbacks(String[] animalDrawbacks) {
        this.animalDrawbacks = animalDrawbacks;
    }
}