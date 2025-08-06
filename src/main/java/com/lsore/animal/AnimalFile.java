package com.lsore.animal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AnimalFile {

    private final ObjectMapper objectMapper;
    private final File file = new File(System.getProperty("user.home") + "/Animal-Shelter-CLI/animals.json");
    private final List<Animal> animalList;

    public AnimalFile() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            animalList = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createFile() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                Files.writeString(file.toPath(), "[]"); // Ensures the file is not empty
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Writes the Animal to the file
     * @param animal the animal to write
     */
    public void write(Animal animal) {
        try {
            animalList.add(animal);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, animalList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the Animal from the file
     * @return the Animal as an object
     */
    public List<Animal> read() {
        try {
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
