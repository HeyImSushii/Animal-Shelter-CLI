package com.lsore;

import com.lsore.cli.AnimalShelterCLI;
import com.lsore.controller.ShelterController;
import com.lsore.service.ShelterService;
import com.lsore.shelter.Shelter;

public class Main {
    private static final Shelter shelter = new Shelter();
    private static final ShelterService shelterService = new ShelterService(shelter);
    private static final ShelterController shelterController = new ShelterController(shelterService);

    public static void main(String[] args) {
        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(shelterService, shelterController);
        animalShelterCLI.start();
    }
}