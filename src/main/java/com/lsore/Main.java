package com.lsore;

import com.lsore.cli.AnimalShelterCLI;
import com.lsore.config.*;
import com.lsore.controller.ShelterController;
import com.lsore.service.ShelterService;
import com.lsore.shelter.Shelter;
import com.lsore.animal.AnimalFile;
import com.lsore.utils.Colors;
import com.lsore.view.*;

import java.io.File;

public class Main {

    private static final AppConfig appConfig = new AppConfig();
    private static final Colors colors = new Colors();

    public static void main(String[] args) {
        // Initialises app architecture
        AppConfigFile appConfigFile = new AppConfigFile(appConfig);
        AnimalFile animalFile = new AnimalFile();
        Shelter shelter = new Shelter();
        ShelterService shelterService = new ShelterService(shelter);
        ShelterController shelterController = new ShelterController(shelterService);
        AnimalConsoleView animalConsoleView = new AnimalConsoleView(shelterController);
        ShelterConsoleView shelterConsoleView = new ShelterConsoleView(shelterController, animalFile);
        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(animalConsoleView, shelterConsoleView);

        createProjectDirectory();
        animalFile.createFile();
        appConfigFile.load();

        // Runs the CLI
        animalShelterCLI.start();
    }

    // Creates project directory if it's missing
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void createProjectDirectory() {
        File directory = new File(System.getProperty("user.home") + "/Animal-Shelter-CLI");
        if (!directory.exists()) {
            System.out.printf("%sThe project directory does not exist!%n", colors.getRed());
            directory.mkdir();
            directory.setReadable(true);
            directory.setWritable(true);
            System.out.printf("%sThe project directory was created at: %s%s%n", colors.getGreen(), colors.getMagenta(), directory.getPath());
        }
    }

    /**
     * Creates an AppConfig instance
     * @return AppConfig instance
     */
    public static AppConfig getAppConfig() {
        return appConfig;
    }
}