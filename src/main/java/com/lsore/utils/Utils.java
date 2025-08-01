package com.lsore.utils;

import java.util.Arrays;
import java.util.Random;

public class Utils {


    /**
     * Generates a random four-digit number.
     * @return random four-digit number
     */
    public int randomIdGenerator() {
        return new Random().nextInt(9000) + 1000;
    }

    /**
     * Checks if the inputted string is a valid enum value
     * @param objects the enum objects
     * @param input the string to find no matches for
     * @return false
     */
    public boolean isValidEnumValue(Object[] objects, String input) {
        return Arrays.stream(objects).noneMatch(match -> match.toString().equalsIgnoreCase(input));
    }
}
