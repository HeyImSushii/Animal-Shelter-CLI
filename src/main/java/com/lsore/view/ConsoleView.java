package com.lsore.view;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.controller.ShelterController;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.handlers.UserInputHandler;
import com.lsore.utils.Colors;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class ConsoleView {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final Utils utils = new Utils();
    private final Colors colors = new Colors();
    private final ShelterController shelterController;

    public ConsoleView(ShelterController shelterController) {
        this.shelterController = shelterController;
    }

    public void promptAddAnimal() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter the specie:");

        switch (animalSpecie) {
            case CAT -> {
                Cat animal = new Cat(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString("name", "Please enter the name:"),
                        animalSpecie,
                        userInputHandler.readLineInteger("age", "Please enter the age:"),
                        userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter the gender:"),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineBoolean("isIndoor", "Is it an indoor cat? (True or False):")
                );
                shelterController.addAnimal(animal);
                System.out.println(colors.getGreen() + "The animal was added to the shelter:");
            }
            case DOG -> {
                Dog animal = new Dog(
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
                shelterController.addAnimal(animal);
                System.out.println(colors.getGreen() + "The animal was added to the shelter:");
            }
            case null, default -> {
            }
        }
    }

    public void promptListAnimalsBySpecie() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter the specie:");
        if (shelterController.getAnimalsBySpecie(animalSpecie).isEmpty()) {
            System.out.printf("%sThere are no animals with the specie %s%s%s in the shelter.%n", colors.getRed(), colors.getMagenta(), animalSpecie, colors.getRed());
            return;
        }
        shelterController.getAnimalsBySpecie(animalSpecie).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    public void promptListAnimalsByAdoptionStatus() {
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum("adoptionStatus", AdoptionStatus.values(), "Please enter the adoption status:");
        if (shelterController.getAnimalsByAdoptionStatus(adoptionStatus).isEmpty()) {
            System.out.printf("%sThere are no animals with the adoption status %s%s%s in the shelter.%n", colors.getRed(), colors.getMagenta(), adoptionStatus, colors.getRed());
            return;
        }
        shelterController.getAnimalsByAdoptionStatus(adoptionStatus).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    public void promptRemoveAnimal() {
        int uniqueId = userInputHandler.readLineInteger("id", "Please enter the ID:");
        if (shelterController.removeAnimal(uniqueId)) {
            shelterController.removeAnimal(uniqueId);
            System.out.printf("%sThe animal with the ID %s%d%s was removed from the shelter.%n", colors.getGreen(), colors.getMagenta(), uniqueId, colors.getGreen());
            return;
        }
        System.out.printf("%sThere is no animals with the ID %s%d%s in the shelter.%n", colors.getRed(), colors.getMagenta(), uniqueId, colors.getRed());
    }


    /**
     * Displays information about the Animal
     * @param animal the animal to show information about
     */
    private void displayAnimalInformation(Animal animal) {
        switch (animal) {
            case Cat cat -> {
                System.out.printf("%sID:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getUniqueId());
                System.out.printf("%sName:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalName());
                System.out.printf("%sSpecie:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalSpecie());
                System.out.printf("%sAge:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getAnimalAge());
                System.out.printf("%sGender:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalName());
                System.out.printf("%sAdded:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getDateOfArrival());
                System.out.printf("%sAdoption Status:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAdoptionStatus());
                System.out.printf("%sisIndoor:%s %s%n", colors.getGreen(), colors.getWhite(), cat.isIndoor());
            }
            case Dog dog -> {
                System.out.printf("%sID:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getUniqueId());
                System.out.printf("%sName:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalName());
                System.out.printf("%sSpecie:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalSpecie());
                System.out.printf("%sAge:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getAnimalAge());
                System.out.printf("%sGender:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalName());
                System.out.printf("%sAdded:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getDateOfArrival());
                System.out.printf("%sAdoption Status:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAdoptionStatus());
                System.out.printf("%sisTrained:%s %s%n", colors.getGreen(), colors.getWhite(), dog.isTrained());
                System.out.printf("%swalkFrequency:%s %s%n", colors.getGreen(), colors.getWhite(), dog.getWalkFrequency());
            }
            case null, default -> {
            }
        }
    }

    public void promptListAnimals() {
        shelterController.getAnimals().forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s──────────────────────────────────────────────────────────────────────────────────%s%n",
                colors.getBlue(), colors.getWhite());
        System.out.printf("There are a total of %s%d%s available, %s%d%s reserved and %s%d%s adopted animals in the shelter.%n",
                colors.getMagenta(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.AVAILABLE),
                colors.getWhite(),
                colors.getMagenta(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.RESERVED),
                colors.getWhite(),
                colors.getMagenta(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.ADOPTED),
                colors.getWhite());
        System.out.printf("%s──────────────────────────────────────────────────────────────────────────────────%s%n",
                colors.getBlue(), colors.getWhite());
    }
}
