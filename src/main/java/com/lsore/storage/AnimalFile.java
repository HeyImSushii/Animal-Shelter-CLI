package com.lsore.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsore.animal.Animal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class AnimalFile {

    private final String directoryPath = System.getProperty("user.home") + "/Animal-Shelter-CLI/";
    private final String filePath = directoryPath + "animals2.json";

    public void createFile() {
        File directory = new File(directoryPath);
        File file = new File(filePath);

        if (!directory.exists() && directory.isDirectory()) {
            System.err.println("The directory " + directory + " does note exist! Creating.");
            directory.mkdir();
            return;
        }

        if (!file.exists()) {
            System.err.println("The file " + filePath + " does note exist! Creating.");
            try {
                file.createNewFile();
                file.setReadable(true);
                file.setWritable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File and directory exists.");
        }
    }

    public void writeToFile(HashSet<Animal> hashSet) {
        try {
            try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                String json = objectMapper.writeValueAsString(hashSet);

                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), hashSet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
