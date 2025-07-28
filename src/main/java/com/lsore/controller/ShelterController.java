package com.lsore.controller;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.handlers.UserInputHandler;
import com.lsore.service.ShelterService;
import com.lsore.utils.Colors;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class ShelterController {

    private final Utils utils = new Utils();
    private final Colors colors = new Colors();
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    public void addAnimal() {
        UserInputHandler userInputHandler = new UserInputHandler();
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter the specie:");

        switch (animalSpecie) {
            case CAT -> {
                Animal animal = new Cat(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString("name", "Please enter the name:"),
                        animalSpecie,
                        userInputHandler.readLineInteger("age", "Please enter the age:"),
                        userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter the gender:"),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineBoolean("isIndoor", "Is it an indoor cat? (True or False):")
                );
                shelterService.addAnimal(animal);
                System.out.println(colors.getGreen() + "The animal was added to the shelter:");
            }
            case DOG -> {
                Animal animal = new Dog(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString("name", "Please enter the name:"),
                        animalSpecie,
                        userInputHandler.readLineInteger("age", "Please enter the age:"),
                        userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter the gender:"),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineBoolean("isTrained", "Is the dog trained? (True or False):"),
                        userInputHandler.readLineInteger("walkFrequency", "Please enter number of daily walks:")
                );
                shelterService.addAnimal(animal);
                System.out.println(colors.getGreen() + "The animal was added to the shelter:");
            }
            case null, default -> {
            }
        }
    }
}
