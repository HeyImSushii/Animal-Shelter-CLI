package com.lsore.config;

import java.io.*;
import java.util.Properties;

public class AppConfigFile {

    private final AppConfig appConfig;
    private final String filePath;

    public AppConfigFile(AppConfig appConfig, String filePath) {
        this.appConfig = appConfig;
        this.filePath = filePath;
        createFile();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createFile() {
        File file = new File(System.getProperty("user.home") + "/Animal-Shelter-CLI/config.properties");
        if (!file.exists()) {
            try {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);

                try (FileWriter fileWriter = new FileWriter(file)) {
                    Properties properties = new Properties();
                    properties.setProperty("app.name", "Animal-Shelter-CLI");
                    properties.setProperty("app.version", "1.0.0");
                    properties.setProperty("github.url", "github.com/HeyImSushii/Animal-Shelter-CLI");
                    properties.store(fileWriter, "App Config");
                } catch (IOException e) {
                    throw new IOException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Loads the properties file, and initialises the AppConfig model
    public void load() {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            appConfig.setAppName(properties.getProperty("app.name"));
            appConfig.setAppVersion(properties.getProperty("app.version"));
            appConfig.setGithubUrl(properties.getProperty("github.url"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
