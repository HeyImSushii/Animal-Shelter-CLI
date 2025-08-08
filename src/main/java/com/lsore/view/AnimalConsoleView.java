package com.lsore.view;

import com.lsore.animal.Animal;
import com.lsore.controller.ShelterController;
import com.lsore.enums.AdoptionStatus;
import com.lsore.enums.MessageType;
import com.lsore.handlers.UserInputHandler;
import com.lsore.utils.MessageUtils;

public class AnimalConsoleView {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final MessageUtils messageUtils = new MessageUtils();
    private final ShelterController shelterController;

    public AnimalConsoleView(ShelterController shelterController) {
        this.shelterController = shelterController;
    }

    // Prompts the required user inputs to update the adoption status of the Animal
    public void promptUpdateAnimalAdoptionStatus() {
        int uniqueId = userInputHandler.readLineInteger(messageUtils.message(MessageType.OPTION, false,"Please enter the ID:"));
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), messageUtils.message(MessageType.OPTION, false,"Please enter the adoption status:"));
        Animal animal = shelterController.getAnimalByUniqueId(uniqueId);
        animal.setAdoptionStatus(adoptionStatus);
        messageUtils.printMessage(MessageType.INFORMATION, false,"The adoption status of the animal has been updated!");
    }

    // Prompts the required user inputs to update the description fo the Animal
    public void promptUpdateAnimalDescription() {
        int uniqueId = userInputHandler.readLineInteger("Please enter the ID:");
        Animal animal = shelterController.getAnimalByUniqueId(uniqueId);
        animal.setAnimalDescription(userInputHandler.readLineStringArray("Please enter the new description:"));
    }
}
