package com.lsore.handlers;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UserInputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final LinkedHashMap<String, String> userInputs;

    public UserInputHandler() {
        userInputs = new LinkedHashMap<>();
    }

    /**
     * Reads user input from CLI as a string
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public String readLineString(String key, String message) {
        System.out.println(message);
        String input = scanner.next();
        userInputs.put(key, input);
        return input;
    }

    /**
     * Reads user input from CLI as an integer
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public int readLineInteger(String key, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.next();
            try {
                int number = Integer.parseInt(input);
                if (!(number >= 0)) {
                    System.err.println("Invalid input! The integer may not be less than 0.");
                }
                userInputs.put(key, Integer.toString(number));
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! The input value was not an integer.");
            }
        }
    }

    /**
     * Reads user input from CLI as a boolean
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public boolean readLineBoolean(String key, String message) {
        System.out.println(message);
        boolean input = scanner.nextBoolean();
        userInputs.put(key, Boolean.toString(input));
        return input;
    }

    /**
     * Reads the user input from the CLI as an enum value
     * @param key the key name to assign to the user input
     * @param values the values of the Enum class to read
     * @param message the message to print to the CLI
     * @return the enum value
     * @param <T> requires the method signature to be an enum
     */
    public <T extends Enum<T>> T readLineEnum(String key, @NotNull T[] values, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.next();
            try {
                T value = Enum.valueOf(values[0].getDeclaringClass(), input.toUpperCase());
                userInputs.put(key, value.name());
                return value;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input! The input value must be: " + Arrays.stream(values).toList());
            }
        }
    }

    /**
     * Contains all keys and values in the HashMap. Only used for temporary storing the user inputs.
     * @return returns the keys and values in the HashMap
     */
    public HashMap<String, String> getUserInputs() {
        return userInputs;
    }
}