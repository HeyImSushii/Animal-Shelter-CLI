package com.lsore.enums;

public enum ColorType {
    BLUE("\u001B[94m"),
    LAVENDER("\u001B[38;5;183m"),
    GREEN("\u001B[38;5;150m"),
    MAGENTA("\u001B[35m"),
    WHITE("\u001B[97m"),
    RED("\u001B[38;5;217m");

    private final String color;

    ColorType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}