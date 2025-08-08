package com.lsore.view;

import com.lsore.Main;
import com.lsore.enums.ColorType;
import com.lsore.enums.MessageType;
import com.lsore.utils.MessageUtils;

public class ConsoleView {

    private final MessageUtils messageUtils = new MessageUtils();

    // Displays the banner
    public void displayBanner() {
        int lineLength = 41;
        messageUtils.printLine(ColorType.BLUE, lineLength);
        messageUtils.printMessageCentered(lineLength, "%s%s v%s".formatted(ColorType.MAGENTA.getColor(), Main.getAppConfig().getAppName(), Main.getAppConfig().getAppVersion()));
        messageUtils.printMessageCentered(lineLength, "Authored by Ludvik Macdonald Sørensen");
        messageUtils.printMessageCentered(0, Main.getAppConfig().getGithubUrl());
        messageUtils.printMessageCentered(lineLength, "Launched in " + Main.getStartTime() + "ms");
        messageUtils.printLine(ColorType.BLUE, lineLength);
    }

    // Displays the main menu
    public void displayMainMenu() {
        messageUtils.printMessage(MessageType.INFORMATION, false,"Please select one of the following options!");
        messageUtils.menuOption(1, "Add Animal");
        messageUtils.menuOption(2, "List All Animals");
        messageUtils.menuOption(3, "Search Animals By Specie");
        messageUtils.menuOption(4, "Search Animals By Adoption Status");
        messageUtils.menuOption(5, "Update Animal Information");
        messageUtils.menuOption(6, "Remove an Animal by ID");
        messageUtils.menuOption(7, "Exit Application");
        messageUtils.menuOption(8, "Clear Console");
    }

    // Displays the sub menu for option 5
    public void displaySubMenu() {
        messageUtils.printMessage(MessageType.INFORMATION, false,"Please select one of the following options!");
        messageUtils.menuOption(1, "Update Adoption Status");
        messageUtils.menuOption(2, "Update Description");
        messageUtils.menuOption(4, "Update Benefits");
        messageUtils.menuOption(5, "Update Drawbacks");
        messageUtils.menuOption(6, "Return To Main Menu");
    }
}
