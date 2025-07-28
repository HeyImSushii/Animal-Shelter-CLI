package com.lsore.utils;

public class Colors {

    protected final String reset = "\u001B[0m";
    protected final String blue = "\u001B[94m";
    protected final String green = "\u001B[38;5;150m";
    protected final String magenta = "\u001B[35m";
    protected final String white = "\u001B[97m";
    protected final String gray = "\u001B[90m";
    protected final String red = "\u001B[38;5;217m";

    public String getReset() {
        return reset;
    }

    public String getBlue() {
        return blue;
    }

    public String getGreen() {
        return green;
    }

    public String getMagenta() {
        return magenta;
    }

    public String getWhite() {
        return white;
    }

    public String getGray() {
        return gray;
    }

    public String getRed() {
        return red;
    }
}
