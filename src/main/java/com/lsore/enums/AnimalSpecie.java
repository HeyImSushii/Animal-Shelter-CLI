package com.lsore.enums;

public enum AnimalSpecie {
    CAT("Cat"),
    DOG("Dog");

    private final String specie;

    AnimalSpecie(String specie) {
        this.specie = specie;
    }

    /**
     * The specie of the animal
     * @return the specie of the animal as a string
     */
    public String getSpecie() {
        return specie;
    }
}
