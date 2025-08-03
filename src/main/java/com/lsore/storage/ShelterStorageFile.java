package com.lsore.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsore.shelter.Shelter;

import java.io.File;
import java.io.IOException;

public class ShelterStorageFile {

    private final ObjectMapper objectMapper;
    private final File file;

    public ShelterStorageFile(String filePath) {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.file = new File(filePath);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createFile() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save(Shelter shelter) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, shelter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Shelter load() {
        try {
            return objectMapper.readValue(file, Shelter.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
