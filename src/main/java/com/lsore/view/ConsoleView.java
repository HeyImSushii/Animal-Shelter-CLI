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

    // Prompts the user inputs required to add an Animal to the shelter
    public void promptAddAnimal() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), "Please enter the specie:");
        switch (animalSpecie) {
            case CAT -> {
                Cat animal = new Cat(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString("Please enter the name:"),
                        animalSpecie,
                        userInputHandler.readLineInteger("Please enter the age:"),
                        userInputHandler.readLineEnum(AnimalGender.values(), "Please enter the gender:"),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray("Please enter a description:"),
                        userInputHandler.readLineStringArray("Please enter the benefits (Separated by whitespace):"),
                        userInputHandler.readLineStringArray("Please enter the drawbacks (Separated by whitespace):"),
                        userInputHandler.readLineBoolean("Is it an indoor cat? (True or False):")
                );
                shelterController.addAnimal(animal);
                System.out.println(colors.getGreen() + "The animal was added to the shelter:");
                displayAnimalInformation(animal);
            }
            case DOG -> {
                Dog animal = new Dog(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString("Please enter the name:"),
                        animalSpecie,
                        userInputHandler.readLineInteger("Please enter the age:"),
                        userInputHandler.readLineEnum(AnimalGender.values(), "Please enter the gender:"),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray("Please enter a description:"),
                        userInputHandler.readLineStringArray("Please enter the benefits (Separated by whitespace):"),
                        userInputHandler.readLineStringArray("Please enter the drawbacks (Separated by whitespace):"),
                        userInputHandler.readLineBoolean("Is the dog trained? (True or False):"),
                        userInputHandler.readLineInteger("Please enter number of daily walks:")
                );
                shelterController.addAnimal(animal);
                System.out.printf("%sThe animal was added to the shelter:%n", colors.getGreen());
            }
            case null, default -> {
            }
        }
    }

    // Displays animals by their specie
    public void promptListAnimalsBySpecie() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), "Please enter the specie:");
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

    // Displays animals by their adoption status
    public void promptListAnimalsByAdoptionStatus() {
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), "Please enter the adoption status:");
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

    // Prompts the required user inputs to remove an Animal from the shelter
    public void promptRemoveAnimal() {
        int uniqueId = userInputHandler.readLineInteger("Please enter the ID:");
        shelterController.removeAnimal(uniqueId);
        System.out.printf("%sThe animal with the ID %s%d%s was removed from the shelter.%n", colors.getGreen(), colors.getMagenta(), uniqueId, colors.getGreen());
    }

    /**
     * Displays information about the Animal
     * @param animal the animal to show information about
     */
    private void displayAnimalInformation(Animal animal) {
        System.out.printf("%sID:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getUniqueId());
        System.out.printf("%sName:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalName());
        System.out.printf("%sSpecie:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalSpecie().getSpecie());
        System.out.printf("%sAge:%s %d%n", colors.getGreen(), colors.getWhite(), animal.getAnimalAge());
        System.out.printf("%sGender:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAnimalGender().getGender());
        System.out.printf("%sAdded:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getDateOfArrival());
        System.out.printf("%sAdoption Status:%s %s%n", colors.getGreen(), colors.getWhite(), animal.getAdoptionStatus().getStatus());
        System.out.printf("%sDescription: %s%s%n", colors.getGreen(), colors.getWhite(), String.join(" ", animal.getAnimalDescription()));
        System.out.printf("%sBenefits: %s%s%n", colors.getGreen(), colors.getWhite(), String.join(", ", animal.getAnimalBenefits()));
        System.out.printf("%sDrawbacks: %s%s%n", colors.getGreen(), colors.getWhite(), String.join(", ", animal.getAnimalDrawbacks()));

        if (animal instanceof Cat) {
            System.out.printf("%sisIndoor:%s %s%n", colors.getGreen(), colors.getWhite(), ((Cat) animal).isIndoor());
        }

        if (animal instanceof Dog) {
            System.out.printf("%sisTrained:%s %s%n", colors.getGreen(), colors.getWhite(), ((Dog) animal).isTrained());
            System.out.printf("%swalkFrequency:%s %s%n", colors.getGreen(), colors.getWhite(), ((Dog) animal).getWalkFrequency());
        }
    }

    // Displays a list of animals
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

    // Prompts the required user inputs to update the adoption status of the Animal
    public void promptUpdateAnimalAdoptionStatus() {
        int uniqueId = userInputHandler.readLineInteger("Please enter the ID:");
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), "Please enter the adoption status:");
        Animal animal = shelterController.getAnimalByUniqueId(uniqueId);
        animal.setAdoptionStatus(adoptionStatus);
        System.out.printf("%sThe adoption status for the animal %s%s%s has been updated to %s%s%n", colors.getGreen(), colors.getMagenta(), animal.getAnimalName(), colors.getGreen(), colors.getMagenta(), adoptionStatus);
    }
}
