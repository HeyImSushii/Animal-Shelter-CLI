package com.lsore.enums;

public enum MessageType {
    INFORMATION("Information"),
    OPTION("Option"),
    SUCCESS("Success"),
    ERROR("Error");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
