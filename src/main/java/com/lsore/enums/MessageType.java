package com.lsore.enums;

public enum MessageType {
    INFORMATION("Information"),
    OPTION("Option"),
    SUCCESS("Success"),
    ERROR("Error"),
    DEFAULT("Default");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }

    private String getType() {
        return type;
    }
}
