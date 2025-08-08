package com.lsore.cli;

import com.lsore.Logger.Logger;
import com.lsore.Main;
import com.lsore.enums.MessageType;
import com.lsore.view.AnimalConsoleView;
import com.lsore.view.ConsoleView;
import com.lsore.view.ShelterConsoleView;
import com.lsore.utils.MessageUtils;

import java.util.Scanner;

public class AnimalShelterCLI {

    private final ConsoleView consoleView = new ConsoleView();
    private final MessageUtils messageUtils = new MessageUtils();
    private final Logger logger = new Logger();
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
        messageUtils.printMessage(MessageType.SUCCESS, true,"Exiting program!");
        System.exit(0);
    }

    // Option 99: Clears the CLI
    private void clearConsole() {
        messageUtils.lineBreak(128);
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
                        default -> messageUtils.printMessage(MessageType.ERROR, true,"Invalid option!");
                    }
                }
                case 6 -> removeAnimal();
                case 7 -> {
                    isRunning = false;
                    exit();
                }
                case 8 -> clearConsole();
                default -> messageUtils.printMessage(MessageType.ERROR,true, "Invalid option!");
            }
        }
    }

    // Runs the CLI
    public void start() {
        logger.write(MessageType.INFORMATION, "The app has been launched! The launch time was ~" + Main.getStartTime() + "ms");
        consoleView.displayBanner();
        handleMainMenuUserInput();
    }
}