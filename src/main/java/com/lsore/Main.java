package com.lsore;

import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.cli.AnimalShelterCLI;
import com.lsore.controller.ShelterController;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.service.ShelterService;
import com.lsore.shelter.Shelter;
import com.lsore.view.ConsoleView;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Shelter shelter = new Shelter();
        ShelterService shelterService = new ShelterService(shelter);
        ShelterController shelterController = new ShelterController(shelterService);
        ConsoleView consoleView = new ConsoleView(shelterController);

        // TESTING ONLY //
        shelter.addAnimal(new Cat(1234, "TestCat1", AnimalSpecie.CAT, 1, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.AVAILABLE, true));
        shelter.addAnimal(new Cat(4321, "TestCat2", AnimalSpecie.CAT, 1, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.RESERVED, false));
        shelter.addAnimal(new Dog(5678, "TestDog1", AnimalSpecie.DOG, 1, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.AVAILABLE, true, 3));
        shelter.addAnimal(new Dog(8765, "TestDog2", AnimalSpecie.DOG, 2, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.ADOPTED, false, 300));
        shelter.addAnimal(new Dog(4444, "TestDog9", AnimalSpecie.DOG, 2, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.ADOPTED, false, 300));
        // TESTING ONLY //

        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(consoleView);
        animalShelterCLI.start();
    }
}