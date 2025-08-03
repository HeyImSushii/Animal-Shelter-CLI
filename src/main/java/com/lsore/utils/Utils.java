package com.lsore.utils;

import java.util.Random;

public class Utils {

    /**
     * Generates a random four-digit number.
     * @return random four-digit number
     */
    public int randomIdGenerator() {
        return new Random().nextInt(9000) + 1000;
    }
}
