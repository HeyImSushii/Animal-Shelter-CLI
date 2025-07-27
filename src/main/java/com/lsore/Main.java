package com.lsore;

import com.lsore.cli.AnimalShelterCLI;
import com.lsore.shelter.Shelter;

public class Main {
    private static final Shelter shelter = new Shelter();

    public static void main(String[] args) {
        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(shelter);
        animalShelterCLI.start();

    }
}