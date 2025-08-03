package com.lsore;

import com.lsore.animal.species.*;
import com.lsore.cli.AnimalShelterCLI;
import com.lsore.config.*;
import com.lsore.controller.ShelterController;
import com.lsore.enums.*;
import com.lsore.service.ShelterService;
import com.lsore.shelter.Shelter;
import com.lsore.storage.ShelterStorageFile;
import com.lsore.utils.Colors;
import com.lsore.view.*;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final AppConfig appConfig = new AppConfig();
    private static ShelterStorageFile shelterStorageFile;
    private static final Colors colors = new Colors();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        // Checks if the project directory exists
        File directory = new File(System.getProperty("user.home") + "/Animal-Shelter-CLI");
        if (!directory.exists()) {
            System.out.printf("%sThe project directory does not exist!%n", colors.getRed());
            directory.mkdir();
            directory.setReadable(true);
            directory.setWritable(true);
            System.out.printf("%sThe project directory was created at: %s%s%n", colors.getGreen(), colors.getMagenta(), directory.getPath());
        }

        // Initialises app architecture
        AppConfigFile appConfigFile = new AppConfigFile(appConfig, directory + "/config.properties");
        shelterStorageFile = new ShelterStorageFile(directory + "/animals.json");
        Shelter shelter = new Shelter();
        ShelterService shelterService = new ShelterService(shelter);
        ShelterController shelterController = new ShelterController(shelterService);
        AnimalConsoleView animalConsoleView = new AnimalConsoleView(shelterController);
        ShelterConsoleView shelterConsoleView = new ShelterConsoleView(shelterController);
        AnimalShelterCLI animalShelterCLI = new AnimalShelterCLI(animalConsoleView, shelterConsoleView);

        shelterStorageFile.createFile();

        /// TESTING PURPOSES ONLY ///
        testObjects(shelter);

        // Initialises the modules
        appConfigFile.load();
        animalShelterCLI.start();
        shelterStorageFile.save(shelter);
    }

    // TESTING PURPOSES ONLY
    private static void testObjects(Shelter shelter) {
        List<String> list = Arrays.asList("element1", "element2");
        shelter.addAnimal(new Cat(1234, "TestCat1", AnimalSpecie.CAT, 1, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.AVAILABLE, new String[]{}, list, list, true));
        shelter.addAnimal(new Cat(4321, "TestCat2", AnimalSpecie.CAT, 1, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.RESERVED, new String[]{"Some", "description", "goes", "here"}, list, list, false));
        shelter.addAnimal(new Dog(5678, "TestDog1", AnimalSpecie.DOG, 1, AnimalGender.MALE, LocalDate.now(), AdoptionStatus.AVAILABLE, new String[]{"Some", "description", "goes", "here"}, list, list, true, 3));
        shelter.addAnimal(new Dog(8765, "TestDog2", AnimalSpecie.DOG, 2, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.ADOPTED, new String[]{"Some", "description", "goes", "here"}, list, list, false, 300));
        shelter.addAnimal(new Dog(4444, "TestDog9", AnimalSpecie.DOG, 2, AnimalGender.FEMALE, LocalDate.now(), AdoptionStatus.ADOPTED, new String[]{"Some", "description", "goes", "here"}, list, list, false, 300));
    }

    /**
     * Creates an AppConfig instance
     * @return AppConfig instance
     */
    public static AppConfig getAppConfig() {
        return appConfig;
    }
}