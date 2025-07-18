package com.lsore.enums;

public enum AdoptionStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    ADOPTED("Adopted");

    private final String status;

    AdoptionStatus(String status) {
        this.status = status;
    }

    /**
     * The adoption status
     * @return the adoption status as a string
     */
    public String getStatus() {
        return status;
    }
}
