package com.lsore.view;

import com.lsore.enums.ColorType;
import com.lsore.enums.MessageType;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ViewComponents {

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
    public void printMessage(MessageType messageType, String message) {
        switch (messageType) {
            case INFORMATION -> System.out.printf("%sℹ️ %s", ColorType.WHITE.getColor(), message);
            case SUCCESS -> System.out.printf("%s✅ %s%s", ColorType.GREEN.getColor(), message, ColorType.WHITE.getColor());
            case ERROR -> System.out.printf("%s❌ %s%s", ColorType.RED.getColor(), message, ColorType.WHITE.getColor());
            case DEFAULT -> System.out.printf("%s%s", ColorType.WHITE.getColor(), message);
        }
    }

    /**
     * Returns a formatted message as a string
     * @param messageType the type of message
     * @param message the message to return
     * @return the message formatted with the correct symbol and color, as a string
     */
    public String message(MessageType messageType, String message) {
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
            case DEFAULT -> {
                return String.format("%s%s", ColorType.WHITE.getColor(), message);
            }
        }
        return null;
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

    public void printList(String key, Object value) {
        System.out.printf("%s%s%s - %s%s%n", ColorType.GREEN.getColor(), key, ColorType.LAVENDER.getColor(), ColorType.WHITE.getColor(), value);
    }
}
