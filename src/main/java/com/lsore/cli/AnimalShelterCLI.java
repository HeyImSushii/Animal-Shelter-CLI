package com.lsore.cli;

import com.lsore.utils.Colors;
import com.lsore.view.AnimalConsoleView;
import com.lsore.view.ConsoleView;
import com.lsore.view.ShelterConsoleView;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AnimalShelterCLI {
    private final Colors colors = new Colors();
    private final ConsoleView consoleView = new ConsoleView();
    private final AnimalConsoleView animalConsoleView;
    private final ShelterConsoleView shelterConsoleView;

    public AnimalShelterCLI(AnimalConsoleView animalConsoleView, ShelterConsoleView shelterConsoleView) {
        this.animalConsoleView = animalConsoleView;
        this.shelterConsoleView = shelterConsoleView;
    }

    // Option 1: Add Animal
    private void addAnimal() {
        shelterConsoleView.promptAddAnimal();
    }

    // Option 2: List All Animals
    private void listAllAnimals() {
        shelterConsoleView.promptListAnimals();
    }

    // Option 3: Search Animals by Specie
    private void listAnimalsBySpecie() {
        shelterConsoleView.promptListAnimalsBySpecie();
    }

    // Option 4: Search by Adoption Status
    private void listAnimalsByAdoptionStatus() {
        shelterConsoleView.promptListAnimalsByAdoptionStatus();
    }

    // Option 6: Removes an Animal from the shelter
    private void removeAnimal() {
        shelterConsoleView.promptRemoveAnimal();
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

    // Handle user input for main menu
    private void handleMainMenuUserInput() {
        boolean isRunning = true;
        while (isRunning) {
            consoleView.displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1 -> addAnimal();
                case 2 -> listAllAnimals();
                case 3 -> listAnimalsBySpecie();
                case 4 -> listAnimalsByAdoptionStatus();
                case 5 -> {
                    consoleView.displaySubMenu();
                    switch (scanner.nextInt()) {
                        case 1 -> animalConsoleView.promptUpdateAnimalAdoptionStatus();
                        case 2 -> animalConsoleView.promptUpdateAnimalDescription();
                        case 3 -> System.out.println("WIP");
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

    // Runs the CLI
    public void start() {
        consoleView.displayBanner();
        handleMainMenuUserInput();
    }
}