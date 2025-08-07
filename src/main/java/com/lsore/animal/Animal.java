package com.lsore.animal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Animal {

    private int uniqueId;
    private String animalName;
    private AnimalSpecie animalSpecie;
    private int animalAge;
    private AnimalGender animalGender;
    private LocalDate dateOfArrival;
    private AdoptionStatus adoptionStatus;
    private String[] animalDescription;
    private List<String> animalBenefits;
    private List<String> animalDrawbacks;

    public Animal(int uniqueId,
                  String animalName,
                  AnimalSpecie animalSpecie,
                  int animalAge,
                  AnimalGender animalGender,
                  LocalDate dateOfArrival,
                  AdoptionStatus adoptionStatus,
                  String[] animalDescription,
                  List<String> animalBenefits,
                  List<String> animalDrawbacks) {
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

    // Required for Jackson
    public Animal() {}


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

    public List<String> getAnimalBenefits() {
        return animalBenefits;
    }

    public void setAnimalBenefits(List<String> animalBenefits) {
        this.animalBenefits = animalBenefits;
    }

    public List<String> getAnimalDrawbacks() {
        return animalDrawbacks;
    }

    public void setAnimalDrawbacks(List<String> animalDrawbacks) {
        this.animalDrawbacks = animalDrawbacks;
    }
}