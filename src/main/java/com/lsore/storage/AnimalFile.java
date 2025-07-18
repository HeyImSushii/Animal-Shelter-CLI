package com.lsore.storage;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class AnimalFile {

    private final String directoryPath = System.getProperty("user.home") + "/Animal-Shelter-CLI/";
    private final String filePath = directoryPath + "animals.json";

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

    public void writeToFile(HashMap<String, String> hashMap) {
        try {
            try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
                gson.toJson(hashMap, fileWriter);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
