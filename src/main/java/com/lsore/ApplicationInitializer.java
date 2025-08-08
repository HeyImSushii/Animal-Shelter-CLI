package com.lsore;

import com.lsore.Logger.Logger;
import com.lsore.enums.ColorType;
import com.lsore.enums.MessageType;
import com.lsore.utils.MessageUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ApplicationInitializer {

    private final MessageUtils messageUtils = new MessageUtils();
    private final Logger logger = new Logger();
    private final String directoryPath = System.getProperty("user.home") + "/Animal-Shelter-CLI";

    public ApplicationInitializer() {
        generateProjectFiles();
    }

    // Creates the project files
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void generateProjectFiles() {
        // Generates the project directory, if it's missing
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
            directory.setReadable(true);
            directory.setWritable(true);
            messageUtils.printMessage(MessageType.SUCCESS, false,"The project directory " + ColorType.MAGENTA.getColor() + directory.getAbsoluteFile() + ColorType.GREEN.getColor() + " was created.");
        }

        logger.write(MessageType.INFORMATION, "The project directory " + directoryPath + " exists.");

        // Creates the animals.json file, if it's missing
        File animalFile = new File(directoryPath + "/animals.json");
        if (!animalFile.exists()) {
            try {
                animalFile.createNewFile();
                animalFile.setWritable(true);
                animalFile.setReadable(true);
                Files.writeString(animalFile.toPath(), "[]"); // Ensures the file is not empty
                messageUtils.printMessage(MessageType.SUCCESS, false,"The file " + ColorType.MAGENTA.getColor() + animalFile.getAbsoluteFile() + ColorType.GREEN.getColor() + " was created.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        logger.write(MessageType.INFORMATION, "The file " + animalFile.getAbsoluteFile() + " exists.");

        // Creates the app config file, if it's missing
        File appConfigFile = new File(directoryPath + "/config.properties");
        if (!appConfigFile.exists()) {
            try {
                appConfigFile.createNewFile();
                appConfigFile.setWritable(true);
                appConfigFile.setReadable(true);
                messageUtils.printMessage(MessageType.SUCCESS, false,"The file " + ColorType.MAGENTA.getColor() + appConfigFile.getAbsoluteFile() + ColorType.GREEN.getColor() + " was created.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        logger.write(MessageType.INFORMATION, "The file " + animalFile.getAbsoluteFile() + " exists.");

        File logFile = new File(directoryPath + "/app.log");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
                logFile.setWritable(true);
                logFile.setReadable(true);
                messageUtils.printMessage(MessageType.SUCCESS, false,"The file " + ColorType.MAGENTA.getColor() + logFile.getAbsoluteFile() + ColorType.GREEN.getColor() + " was created.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        logger.write(MessageType.INFORMATION, "The file " + logFile.getAbsoluteFile() + " exists.");
    }
}
