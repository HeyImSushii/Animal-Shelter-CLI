package com.lsore;

import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.handlers.UserInputHandler;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class Main {
    private static final Shelter shelter = new Shelter();
    private static final Utils utils = new Utils();

    public static void main(String[] args) {
        userInputs();
    }

    private static void userInputs() {
        UserInputHandler userInputHandler = new UserInputHandler();
        Animal animal = new Animal(utils.randomIdGenerator(),
                userInputHandler.readLineString("name", "Please enter name:"),
                userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter specie:"),
                userInputHandler.readLineInteger("age", "Please enter age"),
                userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter gender:"),
                LocalDate.now(),
                AdoptionStatus.AVAILABLE);
        shelter.addAnimal(animal);
    }
}