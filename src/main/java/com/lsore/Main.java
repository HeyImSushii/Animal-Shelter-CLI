package com.lsore;

import com.lsore.utils.Utils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        Utils utils = new Utils();
        InputHandler inputHandler = new InputHandler();

        inputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter specie: ");

        if (AnimalSpecie.valueOf(inputHandler.getUserInputs().get("specie").toUpperCase()).equals(AnimalSpecie.CAT)) {
            inputHandler.getUserInputs().put("id", Integer.toString(utils.randomIdGenerator()));
            inputHandler.readLineString("name", "Please enter name: ");
            inputHandler.readLineInteger("age", "Please enter age: ");
            inputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter gender: ");
            inputHandler.getUserInputs().put("status", AdoptionStatus.AVAILABLE.getStatus());
            inputHandler.readLineBoolean("isIndoor", "Is it an indoor cat? (True or False): ");

            shelter.addAnimal(
                    Integer.parseInt(inputHandler.getUserInputs().get("id")),
                    inputHandler.getUserInputs().get("name"),
                    AnimalSpecie.valueOf(inputHandler.getUserInputs().get("specie").toUpperCase()),
                    Integer.parseInt(inputHandler.getUserInputs().get("age")),
                    AnimalGender.valueOf(inputHandler.getUserInputs().get("gender").toUpperCase()),
                    LocalDate.now(),
                    AdoptionStatus.valueOf(inputHandler.getUserInputs().get("status").toUpperCase()),
                    Boolean.parseBoolean(inputHandler.getUserInputs().get("isIndoor"))
            );
        }

        if (AnimalSpecie.valueOf(inputHandler.getUserInputs().get("specie").toUpperCase()).equals(AnimalSpecie.DOG)) {
            inputHandler.getUserInputs().put("id", Integer.toString(utils.randomIdGenerator()));
            inputHandler.readLineString("name", "Please enter name: ");
            inputHandler.readLineInteger("age", "Please enter age: ");
            inputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter gender: ");
            inputHandler.getUserInputs().put("status", AdoptionStatus.AVAILABLE.getStatus());
            inputHandler.readLineBoolean("isTrained", "Is the dog trained? (True or False): ");
            inputHandler.readLineInteger("walkFrequency", "Please enter walk frequency: " );

            shelter.addAnimal(
                    Integer.parseInt(inputHandler.getUserInputs().get("id")),
                    inputHandler.getUserInputs().get("name"),
                    AnimalSpecie.valueOf(inputHandler.getUserInputs().get("specie").toUpperCase()),
                    Integer.parseInt(inputHandler.getUserInputs().get("age")),
                    AnimalGender.valueOf(inputHandler.getUserInputs().get("gender").toUpperCase()),
                    LocalDate.now(),
                    AdoptionStatus.valueOf(inputHandler.getUserInputs().get("status").toUpperCase()),
                    Boolean.parseBoolean(inputHandler.getUserInputs().get("isTrained")),
                    Integer.parseInt(inputHandler.getUserInputs().get("walkFrequency"))
                    );
        }

        System.out.println(inputHandler.getUserInputs().keySet() + " : " + inputHandler.getUserInputs().entrySet());
        shelter.listAnimals();
    }
}