package com.lsore;

import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.handlers.UserInputHandler;
import com.lsore.storage.AnimalFile;
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

        userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter specie: ");

        if (AnimalSpecie.valueOf(userInputHandler.getUserInputs().get("specie").toUpperCase()).equals(AnimalSpecie.CAT)) {
            userInputHandler.getUserInputs().put("id", Integer.toString(utils.randomIdGenerator()));
            userInputHandler.readLineString("name", "Please enter name: ");
            userInputHandler.readLineInteger("age", "Please enter age: ");
            userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter gender: ");
            userInputHandler.getUserInputs().put("status", AdoptionStatus.AVAILABLE.getStatus());
            userInputHandler.readLineBoolean("isIndoor", "Is it an indoor cat? (True or False): ");

            shelter.addAnimal(
                    Integer.parseInt(userInputHandler.getUserInputs().get("id")),
                    userInputHandler.getUserInputs().get("name"),
                    AnimalSpecie.valueOf(userInputHandler.getUserInputs().get("specie").toUpperCase()),
                    Integer.parseInt(userInputHandler.getUserInputs().get("age")),
                    AnimalGender.valueOf(userInputHandler.getUserInputs().get("gender").toUpperCase()),
                    LocalDate.now(),
                    AdoptionStatus.valueOf(userInputHandler.getUserInputs().get("status").toUpperCase()),
                    Boolean.parseBoolean(userInputHandler.getUserInputs().get("isIndoor"))
            );
        }

        if (AnimalSpecie.valueOf(userInputHandler.getUserInputs().get("specie").toUpperCase()).equals(AnimalSpecie.DOG)) {
            userInputHandler.getUserInputs().put("id", Integer.toString(utils.randomIdGenerator()));
            userInputHandler.readLineString("name", "Please enter name: ");
            userInputHandler.readLineInteger("age", "Please enter age: ");
            userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter gender: ");
            userInputHandler.getUserInputs().put("status", AdoptionStatus.AVAILABLE.getStatus());
            userInputHandler.readLineBoolean("isTrained", "Is the dog trained? (True or False): ");
            userInputHandler.readLineInteger("walkFrequency", "Please enter walk frequency: " );

            shelter.addAnimal(
                    Integer.parseInt(userInputHandler.getUserInputs().get("id")),
                    userInputHandler.getUserInputs().get("name"),
                    AnimalSpecie.valueOf(userInputHandler.getUserInputs().get("specie").toUpperCase()),
                    Integer.parseInt(userInputHandler.getUserInputs().get("age")),
                    AnimalGender.valueOf(userInputHandler.getUserInputs().get("gender").toUpperCase()),
                    LocalDate.now(),
                    AdoptionStatus.valueOf(userInputHandler.getUserInputs().get("status").toUpperCase()),
                    Boolean.parseBoolean(userInputHandler.getUserInputs().get("isTrained")),
                    Integer.parseInt(userInputHandler.getUserInputs().get("walkFrequency"))
            );
        }

        AnimalFile animalFile = new AnimalFile();
        animalFile.createFile();
        animalFile.writeToFile(userInputHandler.getUserInputs());
    }
}