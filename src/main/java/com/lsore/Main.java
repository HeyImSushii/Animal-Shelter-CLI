package com.lsore;

import com.lsore.animal.AnimalFile;
import com.lsore.cli.AnimalShelterCLI;
import com.lsore.config.*;
import com.lsore.controller.ShelterController;
import com.lsore.service.ShelterService;
import com.lsore.shelter.Shelter;
import com.lsore.view.AnimalConsoleView;
import com.lsore.view.ShelterConsoleView;

import java.lang.management.ManagementFactory;

public class Main {

    private static final AppConfig appConfig = new AppConfig();

    public static void main(String[] args) {

        // Initialises app architecture
        ApplicationInitializer applicationInitializer = new ApplicationInitializer();
        applicationInitializer.generateProjectFiles();

        AppConfigFile appConfigFile = new AppConfigFile(appConfig);
        appConfigFile.load();

        Shelter shelter = new Shelter();
        ShelterService shelterService = new ShelterService(shelter);
        ShelterController shelterController = new ShelterController(shelterService);
        AnimalConsoleView animalConsoleView = new AnimalConsoleView(shelterController);
        ShelterConsoleView shelterConsoleView = new ShelterConsoleView(shelterController, new AnimalFile());
        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(animalConsoleView, shelterConsoleView);

        // Runs the CLI
        animalShelterCLI.start();
    }

    /**
     * Creates an AppConfig instance
     * @return AppConfig instance
     */
    public static AppConfig getAppConfig() {
        return appConfig;
    }

    public static long getStartTime() {
        return System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().getStartTime();
    }
}