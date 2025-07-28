package com.lsore.cli;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.controller.ShelterController;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalSpecie;
import com.lsore.service.ShelterService;
import com.lsore.utils.Colors;
import com.lsore.utils.Utils;

import java.util.Scanner;

public class AnimalShelterCLI {
    private final Utils utils = new Utils();
    private final Colors colors = new Colors();
    private final ShelterService shelterService;
    private final ShelterController shelterController;

    public AnimalShelterCLI(ShelterService shelterService, ShelterController shelterController) {
        this.shelterService = shelterService;
        this.shelterController = shelterController;
    }

    // Option 1: Add Animal
    public void addAnimal() {
        shelterController.addAnimal();
    }

    // Option 2: List All Animals
    public void listAllAnimals() {
        shelterService.getAllAnimals().forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s──────────────────────────────────────────────────────────────────────────────────%s%n",
                colors.getBlue(), colors.getWhite());
        System.out.printf("There are a total of %s%d%s available, %s%d%s reserved and %s%d%s adopted animals in the shelter.%n",
                colors.getMagenta(),
                shelterService.getAnimalCountByStatus(AdoptionStatus.AVAILABLE),
                colors.getWhite(),
                colors.getMagenta(),
                shelterService.getAnimalCountByStatus(AdoptionStatus.RESERVED),
                colors.getWhite(),
                colors.getMagenta(),
                shelterService.getAnimalCountByStatus(AdoptionStatus.ADOPTED),
                colors.getWhite());
        System.out.printf("%s──────────────────────────────────────────────────────────────────────────────────%s%n",
                colors.getBlue(), colors.getWhite());
    }

    // Option 3: Search Animals by Specie
    public void listAnimalsBySpecie() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the specie:%n", colors.getGreen());
        String input = scanner.next();
        shelterService.getAnimalsBySpecie(AnimalSpecie.valueOf(input.toUpperCase())).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    // Option 4: Search by Adoption Status
    public void listAnimalsByAdoptionStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the adoption status:%n", colors.getGreen());
        String input = scanner.next();
        shelterService.getAnimalsByAdoptionStatus(AdoptionStatus.valueOf(input.toUpperCase())).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            displayAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    // Option 5:
    // TODO: Add logic...

    // Option 6: Removes an Animal from the shelter
    public void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the ID:%n", colors.getGreen());
        int input = scanner.nextInt();
        if (shelterService.removeAnimalById(input)) {
            System.out.println("The animal was removed.");
            return;
        }
        System.out.printf("%sThere are no animals with the ID %s%d%s in the shelter!%n", colors.getRed(), colors.getMagenta(), input, colors.getRed());
    }

    // Option 7: Exit Program
    public void exit() {
        System.out.println(colors.getGreen() + "Exiting program!");
        System.exit(0);
    }

    // Displays the main menu
    public void displayMainMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sAdd Animal%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sList All Animals%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[3]%s - %sSearch Animals by Specie%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[4]%s - %sSearch Animals by Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[5]%s - %sUpdate Animal Information%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[6]%s - %sRemove Animal by ID%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[7]%s - %sExit Program%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

    // Displays the sub menu for option 5
    public void displaySubMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sUpdate Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sUpdate Description%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[3]%s - %sUpdate Benefits%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[4]%s - %sUpdate Drawbacks%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[7]%s - %sReturn to main menu%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

    // Handle user input for main menu
    private void handleMainMenuUserInput() {
        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            switch (input) {
                case "1" -> addAnimal();
                case "2" -> listAllAnimals();
                case "3" -> listAnimalsBySpecie();
                case "4" -> listAnimalsByAdoptionStatus();
                case "5" -> displaySubMenu();
                case "6" -> removeAnimal();
                case "7" -> {
                    isRunning = false;
                    exit();
                }
                default -> System.err.println("Invalid option!");
            }
        }
    }

    // Displays the banner
    public void displayBanner() {
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getReset());
        System.out.printf("%sAnimal Shelter CLI v1.0.0%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%sGitHub: github.com/HeyImSushii/Animal-Shelter-CLI%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
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

    // Runs the CLI
    public void start() {
        displayBanner();
        handleMainMenuUserInput();
    }
}