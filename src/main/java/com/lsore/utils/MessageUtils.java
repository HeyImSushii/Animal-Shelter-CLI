package com.lsore.utils;

import com.lsore.Logger.Logger;
import com.lsore.enums.ColorType;
import com.lsore.enums.MessageType;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MessageUtils {

    private final Logger logger = new Logger();

    /**
     * Prints menu options to the CLI
     * @param id the option number
     * @param message the option message
     */
    public void menuOption(int id, String message) {
        System.out.printf("%s[%d]%s - %s%s%n", ColorType.GREEN.getColor(), id, ColorType.LAVENDER.getColor(), ColorType.WHITE.getColor(), message);
    }

    /**
     * Prints a formatted message to the CLI
     * @param messageType the type of message
     * @param message the message to print
     */
    public void printMessage(MessageType messageType, boolean logToFile, String message) {

        if (logToFile) logger.write(messageType, message);

        switch (messageType) {
            case INFORMATION -> System.out.printf("%sℹ️ %s", ColorType.WHITE.getColor(), message);
            case OPTION -> System.out.printf("%s➡️ %s%s", ColorType.LAVENDER.getColor(), message, ColorType.WHITE.getColor());
            case SUCCESS -> System.out.printf("%s✅ %s%s", ColorType.GREEN.getColor(), message, ColorType.WHITE.getColor());
            case ERROR -> System.out.printf("%s❌ %s%s", ColorType.RED.getColor(), message, ColorType.WHITE.getColor());
            default -> throw new IllegalStateException("Unexpected value: " + messageType);
        }
    }

    /**
     * Returns a formatted message as a string
     * @param messageType the type of message
     * @param message the message to return
     * @return the message formatted with the correct symbol and color, as a string
     */
    public String message(MessageType messageType, boolean logToFile, String message) {

        if (logToFile) logger.write(messageType, message);

        switch (messageType) {
            case INFORMATION -> {
                return String.format("%sℹ️ %s%s", ColorType.WHITE.getColor(), message, ColorType.WHITE.getColor());
            }
            case OPTION -> {
                return String.format("%s➡️ %s%s", ColorType.LAVENDER.getColor(), message, ColorType.WHITE.getColor());
            }
            case SUCCESS -> {
                return String.format("%s✅ %s%s", ColorType.GREEN.getColor(), message, ColorType.WHITE.getColor());
            }
            case ERROR -> {
                return String.format("%s❌ %s%s", ColorType.RED.getColor(), message, ColorType.WHITE.getColor());
            }
            default -> throw new IllegalStateException("Unexpected value: " + messageType);
        }
    }

    /**
     * Prints a list of messages with a colored line
     * @param colorType the color
     * @param messages the messages
     */
    public void printMessageWithLine(ColorType colorType, String... messages) {
        int maxLength = Arrays.stream(messages).mapToInt(String::length).max().orElse(0);
        String line = String.valueOf('─').repeat(maxLength);
        System.out.println(line);
        Arrays.stream(messages).map(string -> colorType.getColor() + string).forEach(System.out::println);
        System.out.println(line);
    }

    /**
     * Prints and centers the message
     * @param padding the amount of padding to add in total
     * @param message the message to print and center
     */
    public void printMessageCentered(int padding, String message) {
        int totalPadding = padding - message.length();
        int paddingStart = totalPadding / 2;
        int paddingEnd = totalPadding - paddingStart;

        // If the padding is negative, skip it
        if (totalPadding < 0) {
            System.out.println(message);
            return;
        }

        System.out.println(" ".repeat(paddingStart) + message + " ".repeat(paddingEnd));
    }

    /**
     * Prints a color line to the CLI
     * @param colorType the color
     * @param length the length of the line
     */
    public void printLine(ColorType colorType, int length) {
        System.out.println(colorType.getColor() + String.valueOf('─').repeat(length));
    }

    /**
     * Prints line breaks to the CLI
     * @param amount the amount of line breaks
     */
    public void lineBreak(int amount) {
        IntStream.range(0, amount).mapToObj(_ -> "\n").forEach(System.out::println);
    }

    /**
     * Prints a key-value pair
     * @param key the label to print
     * @param value the value to print
     */
    public void printList(String key, Object value) {
        System.out.printf("%s%s%s - %s%s%n", ColorType.GREEN.getColor(), key, ColorType.LAVENDER.getColor(), ColorType.WHITE.getColor(), value);
    }
}
