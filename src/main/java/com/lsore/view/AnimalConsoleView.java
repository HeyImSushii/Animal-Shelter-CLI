package com.lsore.view;

import com.lsore.animal.Animal;
import com.lsore.controller.ShelterController;
import com.lsore.enums.AdoptionStatus;
import com.lsore.handlers.UserInputHandler;
import com.lsore.utils.Colors;

public class AnimalConsoleView {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final Colors colors = new Colors();
    private final ShelterController shelterController;

    public AnimalConsoleView(ShelterController shelterController) {
        this.shelterController = shelterController;
    }

    // Prompts the required user inputs to update the adoption status of the Animal
    public void promptUpdateAnimalAdoptionStatus() {
        int uniqueId = userInputHandler.readLineInteger("Please enter the ID:");
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), "Please enter the adoption status:");
        Animal animal = shelterController.getAnimalByUniqueId(uniqueId);
        animal.setAdoptionStatus(adoptionStatus);
        System.out.printf("%sThe adoption status for the animal %s%s%s has been updated to %s%s%n", colors.getGreen(), colors.getMagenta(), animal.getAnimalName(), colors.getGreen(), colors.getMagenta(), adoptionStatus);
    }

    // Prompts the required user inputs to update the description fo the Animal
    public void promptUpdateAnimalDescription() {
        int uniqueId = userInputHandler.readLineInteger("Please enter the ID:");
        Animal animal = shelterController.getAnimalByUniqueId(uniqueId);
        animal.setAnimalDescription(userInputHandler.readLineStringArray("Please enter the new description:"));
    }
}
