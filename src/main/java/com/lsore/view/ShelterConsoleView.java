package com.lsore.view;

import com.lsore.animal.Animal;
import com.lsore.animal.species.Cat;
import com.lsore.animal.species.Dog;
import com.lsore.controller.ShelterController;
import com.lsore.enums.*;
import com.lsore.handlers.UserInputHandler;
import com.lsore.animal.AnimalFile;
import com.lsore.utils.Utils;

import java.time.LocalDate;

public class ShelterConsoleView {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final Utils utils = new Utils();
    private final ViewComponents viewComponents = new ViewComponents();
    private final ShelterController shelterController;
    private final AnimalFile animalFile;

    public ShelterConsoleView(ShelterController shelterController, AnimalFile animalFile) {
        this.shelterController = shelterController;
        this.animalFile = animalFile;
    }
    // Prompts the user inputs required to add an Animal to the shelter
    public void promptAddAnimal() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), viewComponents.message(MessageType.OPTION, "Please enter the specie:"));

        switch (animalSpecie) {
            case CAT -> {
                Cat animal = new Cat(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString(viewComponents.message(MessageType.OPTION, "Please enter the name:")),
                        animalSpecie,
                        userInputHandler.readLineInteger(viewComponents.message(MessageType.OPTION, "Please enter the age:")),
                        userInputHandler.readLineEnum(AnimalGender.values(), viewComponents.message(MessageType.OPTION, "Please enter the gender:")),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray(viewComponents.message(MessageType.OPTION, "Please enter a description:")),
                        userInputHandler.readLineStringList(viewComponents.message(MessageType.OPTION, "Please enter the benefits (Separated by whitespace):")),
                        userInputHandler.readLineStringList(viewComponents.message(MessageType.OPTION, "Please enter the drawbacks (Separated by whitespace):")),
                        userInputHandler.readLineBoolean(viewComponents.message(MessageType.OPTION, "Is it an indoor cat? (True or False):")));
                shelterController.addAnimal(animal);
                animalFile.write(animal);
                viewComponents.printMessage(MessageType.SUCCESS, "The following animal was added to the shelter:");
                displayAnimalInformation(animal);
            }
            case DOG -> {
                Dog animal = new Dog(
                        utils.randomIdGenerator(),
                        userInputHandler.readLineString(viewComponents.message(MessageType.OPTION, "Please enter the name:")),
                        animalSpecie,
                        userInputHandler.readLineInteger(viewComponents.message(MessageType.OPTION, "Please enter the age:")),
                        userInputHandler.readLineEnum(AnimalGender.values(), viewComponents.message(MessageType.OPTION, "Please enter the gender:")),
                        LocalDate.now(),
                        AdoptionStatus.AVAILABLE,
                        userInputHandler.readLineStringArray(viewComponents.message(MessageType.OPTION, "Please enter a description:")),
                        userInputHandler.readLineStringList(viewComponents.message(MessageType.OPTION, "Please enter the benefits (Separated by whitespace):")),
                        userInputHandler.readLineStringList(viewComponents.message(MessageType.OPTION, "Please enter the drawbacks (Separated by whitespace):")),
                        userInputHandler.readLineBoolean(viewComponents.message(MessageType.OPTION, "Is the dog trained? (True or False):")),
                        userInputHandler.readLineInteger(viewComponents.message(MessageType.OPTION, "Please enter number of daily walks:")));
                shelterController.addAnimal(animal);
                animalFile.write(animal);
                viewComponents.printMessage(MessageType.SUCCESS, "The following animal was added to the shelter:");
                displayAnimalInformation(animal);
            }
            case null, default -> {
            }
        }
    }

    // Displays animals by their specie
    public void promptListAnimalsBySpecie() {
        AnimalSpecie animalSpecie = userInputHandler.readLineEnum(AnimalSpecie.values(), viewComponents.message(MessageType.OPTION, "Please enter the specie:"));
        if (shelterController.getAnimalsBySpecie(animalSpecie).isEmpty()) {
            viewComponents.printMessage(MessageType.ERROR, "There are no animals with the specie %s%s%s in the shelter.".formatted(ColorType.MAGENTA.getColor(), animalSpecie, ColorType.RED.getColor()));
            return;
        }
        shelterController.getAnimalsBySpecie(animalSpecie).forEach(animal -> {
            viewComponents.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        viewComponents.printLine(ColorType.BLUE, 32);
    }

    // Displays animals by their adoption status
    public void promptListAnimalsByAdoptionStatus() {
        AdoptionStatus adoptionStatus = userInputHandler.readLineEnum(AdoptionStatus.values(), viewComponents.message(MessageType.OPTION, "Please enter the adoption status:"));
        if (shelterController.getAnimalsByAdoptionStatus(adoptionStatus).isEmpty()) {
            viewComponents.printMessage(MessageType.ERROR, "There are no animals with the adoption status %s%s%s in the shelter.".formatted(ColorType.MAGENTA.getColor(), adoptionStatus, ColorType.RED.getColor()));
            return;
        }
        shelterController.getAnimalsByAdoptionStatus(adoptionStatus).forEach(animal -> {
            viewComponents.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        viewComponents.printLine(ColorType.BLUE, 32);
    }

    // Prompts the required user inputs to remove an Animal from the shelter
    public void promptRemoveAnimal() {
        int uniqueId = userInputHandler.readLineInteger(viewComponents.message(MessageType.OPTION, "Please enter the ID:"));
        shelterController.removeAnimal(uniqueId);
        viewComponents.printMessage(MessageType.SUCCESS, "The animal was removed from the shelter!");
    }

    /**
     * Displays information about the Animal
     * @param animal the animal to show information about
     */
    private void displayAnimalInformation(Animal animal) {
        viewComponents.printList("ID", animal.getUniqueId());
        viewComponents.printList("Name", animal.getAnimalName());
        viewComponents.printList("Specie", animal.getAnimalSpecie().getSpecie());
        viewComponents.printList("Age", animal.getAnimalAge());
        viewComponents.printList("Gender", animal.getAnimalGender().getGender());
        viewComponents.printList("Date of Arrival", animal.getDateOfArrival());
        viewComponents.printList("Adoption Status", animal.getAdoptionStatus().getStatus());
        viewComponents.printList("Description", String.join("", animal.getAnimalDescription()));
        viewComponents.printList("Benefits", String.join(", ", animal.getAnimalBenefits()));
        viewComponents.printList("Drawbacks", String.join(", ", animal.getAnimalDrawbacks()));

        if (animal instanceof Cat)
            viewComponents.printList("Indoor", ((Cat) animal).isIndoor() ? "Yes" : "No");

        if (animal instanceof Dog) {
            viewComponents.printList("Trained", ((Dog) animal).isTrained() ? "Yes" : "No");
            viewComponents.printList("Walk Frequency", ((Dog) animal).getWalkFrequency());
        }
    }

    // Displays a list of animals
    public void promptListAnimals() {
        shelterController.getAnimals().forEach(animal -> {
            viewComponents.printLine(ColorType.BLUE, 32);
            displayAnimalInformation(animal);
        });
        viewComponents.printLine(ColorType.BLUE, 82);
        viewComponents.printMessage(MessageType.INFORMATION, "There is a total of %s%d%s available, %s%d%s reserved and %s%d%s adopted animals in the shelter.%n".formatted(ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.AVAILABLE),
                ColorType.WHITE.getColor(), ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.RESERVED),
                ColorType.WHITE.getColor(), ColorType.MAGENTA.getColor(),
                shelterController.getAnimalCountByStatus(AdoptionStatus.ADOPTED), ColorType.WHITE.getColor()));
        viewComponents.printLine(ColorType.BLUE, 82);
    }
}
