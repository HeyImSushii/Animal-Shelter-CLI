package com.lsore.Logger;

import com.lsore.enums.MessageType;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    /**
     * Writes a message to the log file
     * @param messageType the type of message
     * @param message the message to write
     */
    public void write(MessageType messageType, String message) {
        try (FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Animal-Shelter-CLI/app.log", true)) {
            fileWriter.write("%s | %s | %s\n".formatted(
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    messageType.getType().toUpperCase(),
                    message));
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
