package com.lsore.cli;

import com.lsore.utils.Colors;
import com.lsore.view.ConsoleView;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AnimalShelterCLI {
    private final Colors colors = new Colors();
    private final ConsoleView consoleView;

    public AnimalShelterCLI(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    // Option 1: Add Animal
    private void addAnimal() {
        consoleView.promptAddAnimal();
    }

    // Option 2: List All Animals
    private void listAllAnimals() {
        consoleView.promptListAnimals();
    }

    // Option 3: Search Animals by Specie
    private void listAnimalsBySpecie() {
        consoleView.promptListAnimalsBySpecie();
    }

    // Option 4: Search by Adoption Status
    private void listAnimalsByAdoptionStatus() {
        consoleView.promptListAnimalsByAdoptionStatus();
    }

    // Option 5:
    // TODO: Add logic to submenu

    // Option 6: Removes an Animal from the shelter
    private void removeAnimal() {
        consoleView.promptRemoveAnimal();
    }

    // Option 7: Exit Program
    private void exit() {
        System.out.println(colors.getGreen() + "Exiting program!");
        System.exit(0);
    }

    // Option 99: Clears the CLI
    private void clearConsole() {
        IntStream.range(0, 128).mapToObj(_ -> " ").forEach(System.out::println);
    }

    // Displays the main menu
    private void displayMainMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sAdd Animal%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sList All Animals%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[3]%s - %sSearch Animals by Specie%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[4]%s - %sSearch Animals by Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[5]%s - %sUpdate Animal Information%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[6]%s - %sRemove Animal by ID%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[7]%s - %sExit Program%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[8]%s - %sClear Console%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

    // Displays the sub menu for option 5
    private void displaySubMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sUpdate Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sUpdate Description%n", colors.getGreen(), colors.getGray(), colors.getWhite()); // TODO: Implement logic
        System.out.printf("%s[3]%s - %sUpdate Benefits%n", colors.getGreen(), colors.getGray(), colors.getWhite()); // TODO: Implement logic
        System.out.printf("%s[4]%s - %sUpdate Drawbacks%n", colors.getGreen(), colors.getGray(), colors.getWhite()); // TODO: Implement logic
        System.out.printf("%s[7]%s - %sReturn to main menu%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

    // Handle user input for main menu
    private void handleMainMenuUserInput() {
        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1 -> addAnimal();
                case 2 -> listAllAnimals();
                case 3 -> listAnimalsBySpecie();
                case 4 -> listAnimalsByAdoptionStatus();
                case 5 -> {
                    displaySubMenu();
                    switch (scanner.nextInt()) {
                        case 1 -> consoleView.promptUpdateAnimalAdoptionStatus();
                        case 2 -> System.out.println("Suboption 2");
                        default -> System.err.println("Invalid option!");
                    }
                }
                case 6 -> removeAnimal();
                case 7 -> {
                    isRunning = false;
                    exit();
                }
                case 8 -> clearConsole();
                default -> System.err.println("Invalid option!");
            }
        }
    }

    // Displays the banner
    private void displayBanner() {
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getReset());
        System.out.printf("%sAnimal Shelter CLI v1.0.0%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%sGitHub: github.com/HeyImSushii/Animal-Shelter-CLI%s%n", colors.getMagenta(), colors.getWhite());
        System.out.printf("%s─────────────────────────────────────────────────%s%n", colors.getBlue(), colors.getWhite());
    }

    // Runs the CLI
    public void start() {
        displayBanner();
        handleMainMenuUserInput();
    }
}