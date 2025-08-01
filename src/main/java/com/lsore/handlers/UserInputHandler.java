package com.lsore.handlers;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UserInputHandler {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads the user input from the CLI as a string
     * @param message the message to print to the CLI
     * @return returns the user input as a string
     */
    public String readLineString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Reads the user input from the CLI as a string array
     * @param message the message to print to the CLI
     * @return returns the user input as a string array
     */
    public String[] readLineStringArray(String message) {
        System.out.println(message);
        return scanner.nextLine().trim().split("\\s+");
    }

    /**
     * Reads the user input from the CLI as an integer
     * @param message the message to print to the CLI
     * @return returns the user input as an integer
     */
    public int readLineInteger(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (!(number >= 0)) {
                    System.err.println("Invalid input! The integer may not be less than 0.");
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! The input value was not an integer.");
            }
        }
    }

    /**
     * Reads the ser input from the CLI as a boolean
     * @param message the message to print to the CLI
     * @return returns True or False
     */
    public boolean readLineBoolean(String message) {
        System.out.println(message);
        return scanner.nextBoolean();
    }

    /**
     * Reads the user input from the CLI as an enum value
     * @param values the values of the Enum class to read
     * @param message the message to print to the CLI
     * @return the enum value
     * @param <T> requires the method signature to be an enum
     */
    public <T extends Enum<T>> T readLineEnum(@NotNull T[] values, String message) {
        while (true) {
            System.out.println(message);
            try {
                return Enum.valueOf(values[0].getDeclaringClass(), scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input! The input value must be: " + Arrays.stream(values).toList());
            }
        }
    }
}