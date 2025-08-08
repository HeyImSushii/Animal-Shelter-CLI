package com.lsore.view;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.controller.ShelterController;
import com.lsore.enums.*;
import com.lsore.handlers.UserInputHandler;
import com.lsore.animal.AnimalFile;
import com.lsore.utils.MessageUtils;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class ShelterConsoleView {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final Utils utils = new Utils();
    private final MessageUtils messageUtils = new MessageUtils();
    private final ShelterController shelterController;
    private final AnimalFile animalFile;

    public ShelterConsoleView(ShelterController shelterController, AnimalFile animalFile) {
        this.shelterController = shelterController;
        this.animalFile = animalFile;
    }
    // Prompts the user inputs required to add an Animal to the shelter
    public void promptAddAnimal() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), messageUtils.message(MessageType.OPTION,false, "Please enter the specie:"));
        switch (animalSpecie) {
            case CAT -> {
                Cat animal = new Cat(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString(messageUtils.message(MessageType.OPTION, false,"Please enter the name:")),
                        animalSpecie,
                        userInputHandler.readLineInteger(messageUtils.message(MessageType.OPTION, false,"Please enter the age:")),
                        userInputHandler.readLineEnum(AnimalGender.values(), messageUtils.message(MessageType.OPTION, false,"Please enter the gender:")),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray(messageUtils.message(MessageType.OPTION, false,"Please enter a description:")),
                        userInputHandler.readLineStringList(messageUtils.message(MessageType.OPTION, false,"Please enter the benefits (Separated by whitespace):")),
                        userInputHandler.readLineStringList(messageUtils.message(MessageType.OPTION, false,"Please enter the drawbacks (Separated by whitespace):")),
                        userInputHandler.readLineBoolean(messageUtils.message(MessageType.OPTION, false,"Is it an indoor cat? (True or False):")));
                shelterController.addAnimal(animal);
                animalFile.write(animal);
                messageUtils.printMessage(MessageType.SUCCESS, false,"The following animal was added to the shelter:");
                displayAnimalInformation(animal);
            }
            case DOG -> {
                Dog animal = new Dog(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString(messageUtils.message(MessageType.OPTION, false,"Please enter the name:")),
                        animalSpecie,
                        userInputHandler.readLineInteger(messageUtils.message(MessageType.OPTION, false,"Please enter the age:")),
                        userInputHandler.readLineEnum(AnimalGender.values(), messageUtils.message(MessageType.OPTION, false,"Please enter the gender:")),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray(messageUtils.message(MessageType.OPTION, false, "Please enter a description:")),
                        userInputHandler.readLineStringList(messageUtils.message(MessageType.OPTION, false,"Please enter the benefits (Separated by whitespace):")),
                        userInputHandler.readLineStringList(messageUtils.message(MessageType.OPTION, false,"Please enter the drawbacks (Separated by whitespace):")),
                        userInputHandler.readLineBoolean(messageUtils.message(MessageType.OPTION, false,"Is the dog trained? (True or False):")),
                        userInputHandler.readLineInteger(messageUtils.message(MessageType.OPTION, false,"Please enter number of daily walks:")));
                shelterController.addAnimal(animal);
                animalFile.write(animal);
                messageUtils.printMessage(MessageType.SUCCESS, false,"The following animal was added to the shelter:");
                displayAnimalInformation(animal);
            }
            case null, default -> {
            }
        }
    }

    // Displays animals by their specie
    public void promptListAnimalsBySpecie() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), messageUtils.message(MessageType.OPTION, false,"Please enter the specie:"));
        if (shelterController.getAnimalsBySpecie(animalSpecie).isEmpty()) {
            messageUtils.printMessage(MessageType.ERROR, false,"There are no animals with the specie %s%s%s in the shelter.".formatted(ColorType.MAGENTA.getColor(), animalSpecie, ColorType.RED.getColor()));
            return;
        }
        shelterController.getAnimalsBySpecie(animalSpecie).forEach(animal -> {
            messageUtils.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        messageUtils.printLine(ColorType.BLUE, 32);
    }

    // Displays animals by their adoption status
    public void promptListAnimalsByAdoptionStatus() {
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), messageUtils.message(MessageType.OPTION, false,"Please enter the adoption status:"));
        if (shelterController.getAnimalsByAdoptionStatus(adoptionStatus).isEmpty()) {
            messageUtils.printMessage(MessageType.ERROR, false,"There are no animals with the adoption status %s%s%s in the shelter.".formatted(ColorType.MAGENTA.getColor(), adoptionStatus, ColorType.RED.getColor()));
            return;
        }
        shelterController.getAnimalsByAdoptionStatus(adoptionStatus).forEach(animal -> {
            messageUtils.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        messageUtils.printLine(ColorType.BLUE, 32);
    }

    // Prompts the required user inputs to remove an Animal from the shelter
    public void promptRemoveAnimal() {
        int uniqueId = userInputHandler.readLineInteger(messageUtils.message(MessageType.OPTION, false,"Please enter the ID:"));
        shelterController.removeAnimal(uniqueId);
        messageUtils.printMessage(MessageType.SUCCESS, false,"The animal was removed from the shelter!");
    }

    /**
     * Displays information about the Animal
     * @param animal the animal to show information about
     */
    private void displayAnimalInformation(Animal animal) {
        messageUtils.printList("ID", animal.getUniqueId());
        messageUtils.printList("Name", animal.getAnimalName());
        messageUtils.printList("Specie", animal.getAnimalSpecie().getSpecie());
        messageUtils.printList("Age", animal.getAnimalAge());
        messageUtils.printList("Gender", animal.getAnimalGender().getGender());
        messageUtils.printList("Date of Arrival", animal.getDateOfArrival());
        messageUtils.printList("Adoption Status", animal.getAdoptionStatus().getStatus());
        messageUtils.printList("Description", String.join("", animal.getAnimalDescription()));
        messageUtils.printList("Benefits", String.join(", ", animal.getAnimalBenefits()));
        messageUtils.printList("Drawbacks", String.join(", ", animal.getAnimalDrawbacks()));

        if (animal instanceof Cat)
            messageUtils.printList("Indoor", ((Cat) animal).isIndoor() ? "Yes" : "No");

        if (animal instanceof Dog) {
            messageUtils.printList("Trained", ((Dog) animal).isTrained() ? "Yes" : "No");
            messageUtils.printList("Walk Frequency", ((Dog) animal).getWalkFrequency());
        }
    }

    // Displays a list of animals
    public void promptListAnimals() {
        shelterController.getAnimals().forEach(animal -> {
            messageUtils.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        messageUtils.printLine(ColorType.BLUE, 82);
        messageUtils.printMessage(MessageType.INFORMATION, false,"There is a total of %s%d%s available, %s%d%s reserved and %s%d%s adopted animals in the shelter.%n".formatted(ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.AVAILABLE),
                ColorType.WHITE.getColor(), ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.RESERVED),
                ColorType.WHITE.getColor(), ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.ADOPTED), ColorType.WHITE.getColor()));
        messageUtils.printLine(ColorType.BLUE, 82);
    }
}
