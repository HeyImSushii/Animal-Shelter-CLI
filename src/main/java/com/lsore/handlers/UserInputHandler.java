package com.lsore.handlers;

import com.lsore.utils.Colors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class UserInputHandler {

    private final Colors colors = new Colors();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads the user input from the CLI as a string
     * @param message the message to print to the CLI
     * @return returns the user input as a string
     */
    public String readLineString(String message) {
        if (!(message == null)) System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Reads the user input from the CLI as a string array
     * @param message the message to print to the CLI
     * @return returns the user input as a string array
     */
    public String[] readLineStringArray(String message) {
        if (!(message == null)) System.out.println(message);
        return scanner.nextLine().trim().split("\\s+");
    }

    /**
     * Reads the user input from the CLI as a string list
     * @param message the message to print to the CLI
     * @return returns the user input as a string list
     */
    public List<String> readLineStringList(String message) {
        if (!(message == null)) System.out.println(message);
        return List.of(scanner.nextLine());
    }

    /**
     * Reads the user input from the CLI as an integer
     * @param message the message to print to the CLI
     * @return returns the user input as an integer
     */
    public int readLineInteger(@Nullable String message) {
        while (true) {
            if (!(message == null)) System.out.println(message);
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                if (!(number >= 0)) System.err.println("Invalid input! The integer may not be less than 0.");
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
        if (!(message == null)) System.out.println(message);
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
            if (!(message == null)) System.out.println(message);
            try {
                return Enum.valueOf(values[0].getDeclaringClass(), scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.printf("%sInvalid input! The input value must be: %s%s%n%s", colors.getRed(), colors.getMagenta(), Arrays.stream(values).map(Enum::name).collect(Collectors.joining(", ")), colors.getWhite());
            }
        }
    }
}