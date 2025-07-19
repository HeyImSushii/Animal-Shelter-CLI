package com.lsore.cli;

import com.lsore.shelter.Shelter;
import com.lsore.animal.Animal;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.AnimalGender;
import com.lsore.enums.AnimalSpecie;
import com.lsore.handlers.UserInputHandler;
import com.lsore.utils.Colors;
import com.lsore.utils.Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class AnimalShelterCLI {
    private final Colors colors = new Colors();
    private final Utils utils = new Utils();
    private final Shelter shelter;

    public AnimalShelterCLI(Shelter shelter) {
        this.shelter = shelter;
    }

    /**
     * Prints the banner
     */
    public void showBanner() {
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getReset());
        System.out.printf("%sAnimal Shelter CLI v1.0.0%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%sGitHub: github.com/HeyImSushii/Animal-Shelter-CLI%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }


    /**
     * Prints the main menu
     */
    public void showMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sAdd Animal%n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
        System.out.printf("%s[2]%s - %sList All Animals%n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
        System.out.printf("%s[3]%s - %sSearch Animals by Specie%n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
        System.out.printf("%s[4]%s - %sSearch Animals by Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
        System.out.printf("%s[5]%s - %sUpdate Animal Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[6]%s - %sRemove Animal by ID%n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
        System.out.printf("%s[7]%s - %sExit Program%n\n", colors.getGreen(), colors.getGray(), colors.getWhite()); 
    }

    /**
     * Option 1: Adds an animal to the shelter
     */
    public void addAnimal() {
        UserInputHandler userInputHandler = new UserInputHandler();
        Animal animal = new Animal(
                utils.randomIdGenerator(),
                userInputHandler.readLineString("name", "Please enter the name:"),
                userInputHandler.readLineEnum("specie", AnimalSpecie.values(), "Please enter the specie:"),
                userInputHandler.readLineInteger("age", "Please enter the age:"),
                userInputHandler.readLineEnum("gender", AnimalGender.values(), "Please enter the gender:"),
                LocalDate.now(),
                AdoptionStatus.AVAILABLE);
        shelter.addAnimal(animal);
        System.out.println(colors.getGreen() + "The following animal was added to the shelter:");
        showAnimalInformation(animal);
    }

    /**
     * Option 6: Removes an animal from the shelter, by its ID
     */
    public void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the ID:%n", colors.getGreen());
        int input = scanner.nextInt();
        shelter.removeAnimal(input);
        System.out.printf("%sThe animal with the ID %s%d%s was successfully removed.%n", colors.getGreen(), colors.getMagenta(), input, colors.getWhite());
    }

    /**
     * Option 2: Lists all animals in the shelter regardless of adoption status
     * TODO: Make it only show available or reserved animals. Perhaps add another option to view adopted animals
     */
    public void listAllAnimals() {
        shelter.getAnimals().forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            showAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
        System.out.printf("There are a total of %s%d%s available, %s%d%s reserved and %s%d%s adopted animals in the shelter.%n",
                colors.getMagenta(),
                shelter.getAnimalsCount(AdoptionStatus.AVAILABLE),
                colors.getWhite(),
                colors.getMagenta(),
                shelter.getAnimalsCount(AdoptionStatus.RESERVED),
                colors.getWhite(),
                colors.getMagenta(),
                shelter.getAnimalsCount(AdoptionStatus.ADOPTED),
                colors.getWhite());
    }

    /**
     * Option 3: Lists animals by specie
     */
    public void listAnimalsBySpecie() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the specie:%n", colors.getGreen());
        String input = scanner.next();
        shelter.getAnimalsBySpecie(AnimalSpecie.valueOf(input.toUpperCase())).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            showAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    /**
     * Option 4: Lists animals by specie
     */
    public void listAnimalsByAdoptionStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the adoption status:%n", colors.getGreen());
        String input = scanner.next();
        shelter.getAnimalsByAdoptionStatus(AdoptionStatus.valueOf(input.toUpperCase())).forEach(animal -> {
            System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
            showAnimalInformation(animal);
        });
        System.out.printf("%s────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    /**
     * Option 5: Updates the adoption status of an animal, by its ID
     * TODO: Replace with submenu, to easily update all information regarding the animal
     */
    public void updateAnimalAdoptionStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sPlease enter the ID:%n", colors.getGreen());
        int id = scanner.nextInt();

        System.out.printf("%sPlease enter the adoption status:%n", colors.getGreen());
        String adoptionStatus = scanner.next();

        shelter.getAnimalById(id).setAdoptionStatus(AdoptionStatus.valueOf(adoptionStatus.toUpperCase()));
        System.out.println(colors.getGreen() + "The adoption status for the animal with ID " + colors.getMagenta() + id + colors.getGreen() + " has been changed to " + colors.getMagenta() + shelter.getAnimalById(id).getAdoptionStatus());

    }

    /**
     * Option 7: Exits the program
     */
    public void exit() {
        System.out.println(colors.getGreen() + "Exiting program!");
        System.exit(0);
    }

    private void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input) {
            case "1" -> addAnimal();
            case "2" -> listAllAnimals();
            case "3" -> listAnimalsBySpecie();
            case "4" -> listAnimalsByAdoptionStatus();
            case "5" -> updateAnimalAdoptionStatus();
            case "6" -> removeAnimal();
            case "7" -> exit();
            default -> System.err.println("Invalid option!");
        }
    }

    /**
     * Prints information about the animal
     * @param animal the animal object
     */
    private void showAnimalInformation(Animal animal) {
        System.out.printf("%sID: %s%d%n", colors.getGreen(), colors.getWhite(), animal.getId());
        System.out.printf("%sName: %s%s%n", colors.getGreen(), colors.getWhite(), animal.getName());
        System.out.printf("%sSpecie: %s%s%n", colors.getGreen(), colors.getWhite(), animal.getSpecie().getSpecie());
        System.out.printf("%sAge: %s%d%n", colors.getGreen(), colors.getWhite(), animal.getAge());
        System.out.printf("%sDate of Arrival: %s%s%n", colors.getGreen(), colors.getWhite(), animal.getDateOfArrival());
        System.out.printf("%sAdoption Status: %s%s%n", colors.getGreen(), colors.getWhite(), animal.getAdoptionStatus().getStatus());
    }

    /**
     * Runs the CLI
     */
    public void start() {
        showBanner();
        showMenu();
        handleUserInput();
    }
}