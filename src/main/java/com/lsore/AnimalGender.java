package com.lsore;

public enum AnimalGender {
    MALE("Male"),
    FEMALE("Female");

    private final String gender;

    AnimalGender(String gender) {
        this.gender = gender;
    }

    /**
     * The gender of the animal
     * @return the gender of the animal as a string
     */
    public String getGender() {
        return gender;
    }
}
