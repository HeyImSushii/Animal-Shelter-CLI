package com.lsore;

import com.lsore.animal.Animal;
import com.lsore.cli.AnimalShelterCLI;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.shelter.Shelter;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class Main {
    private static final Shelter shelter = new Shelter();
    private static final Utils utils = new Utils();

    public static void main(String[] args) {
        /// TESTING PURPOSES ONLY ///
        shelter.addAnimal(new Animal(1234, "Leo", AnimalSpecie.CAT, 3, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.AVAILABLE));
        shelter.addAnimal(new Animal(utils.randomIdGenerator(), "Loaf", AnimalSpecie.DOG, 3, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.RESERVED));
        shelter.addAnimal(new Animal(utils.randomIdGenerator(), "Whiskey", AnimalSpecie.CAT, 5, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.ADOPTED));
        /// TESTING PURPOSES ONLY ///

        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(shelter);
        animalShelterCLI.start();
    }
}