package com.lsore.animal;

import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;

import java.time.LocalDate;

public class Animal {

    private int id;
    private String name;
    private AnimalSpecie specie;
    private int age;
    private AnimalGender gender;
    private LocalDate dateOfArrival;
    private AdoptionStatus adoptionStatus;

    public Animal(int id, String name, AnimalSpecie specie, int age, AnimalGender gender, LocalDate dateOfArrival, AdoptionStatus adoptionStatus) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.age = age;
        this.gender = gender;
        this.dateOfArrival = dateOfArrival;
        this.adoptionStatus = adoptionStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalSpecie getSpecie() {
        return specie;
    }

    public void setSpecie(AnimalSpecie specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
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
