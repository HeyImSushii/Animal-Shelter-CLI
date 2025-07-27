package com.lsore.handlers;

import com.lsore.utils.Utils;

import java.util.*;

public class UserInputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final Utils utils = new Utils();
    private final LinkedHashMap<String, String> userInputs;

    public UserInputHandler() {
        userInputs = new LinkedHashMap<>();
    }

    /**
     * Reads user input from CLI as a string
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public Optional<String> readLineString(String key, String message) {
        System.out.println(message);
        String input = scanner.next();
        userInputs.put(key, input);
        return Optional.of(input);
    }

    /**
     * Reads user input from CLI as an integer
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public Optional<Integer> readLineInteger(String key, String message) {
        System.out.println(message);
        int input = scanner.nextInt();
        userInputs.put(key, Integer.toString(input));
        return Optional.of(input);
    }

    /**
     * Reads user input from CLI as a boolean
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public Optional<Boolean> readLineBoolean(String key, String message) {
        System.out.println(message);
        boolean input = scanner.nextBoolean();
        userInputs.put(key, Boolean.toString((input)));
        return Optional.of(input);
    }

    /**
     *Reads the user input from the CLI as an enum value
     * @param key the key name to assign to the user input
     * @param values the values of the Enum class to read
     * @param message the message to print to the CLI
     * @return the enum value
     * @param <T> requires the method signature to be an enum
     */
    public <T extends Enum<T>> T readLineEnum(String key, T[] values, String message) {
        System.out.println(message);
        String input = scanner.next();

        // Checks if the provided enum values are valid
        if (utils.isValidEnumValue(values, input)) {
            System.err.println("Invalid specie type!");
            return null;
        }

        // Returns the enum value
        T value = Enum.valueOf(values[0].getDeclaringClass(), input.toUpperCase());
        userInputs.put(key, value.name());
        return value;
    }

    /**
     * Contains all keys and values in the HashMap. Only used for temporary storing the user inputs.
     * @return returns the keys and values in the HashMap
     */
    public HashMap<String, String> getUserInputs() {
        return userInputs;
    }
}
