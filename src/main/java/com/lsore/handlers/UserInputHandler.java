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
     * Reads user input from CLI
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public void readLineString(String key, String message) {
        System.out.println(message);
        userInputs.put(key, scanner.next());
    }

    /**
     * Reads user input from CLI
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public void readLineInteger(String key, String message) {
        System.out.println(message);
        userInputs.put(key, Integer.toString(scanner.nextInt()));
    }

    /**
     * Reads user input from CLI
     * @param key the key name to assign to the user input
     * @param message the message to print to the CLI
     */
    public void readLineBoolean(String key, String message) {
        System.out.println(message);
        userInputs.put(key, Boolean.toString((scanner.nextBoolean())));
    }

    /**
     * Reads user input from CLI
     * @param key the key name to assign to the user input
     * @param object the enum object to read the input from
     * @param message the message to print to the CLI
     */
    public void readLineEnum(String key, Object[] object, String message) {
        System.out.println(message);
        String input = scanner.next();
        if (utils.isValidEnumValue(object, input)) {
            System.err.println("Invalid specie type!");
            return;
        }

        userInputs.put(key, input);
    }

    /**
     * Contains all keys and values in the HashMap. Only used for temporary storing the user inputs.
     * @return returns the keys and values in the HashMap
     */
    public HashMap<String, String> getUserInputs() {
        return userInputs;
    }
}
