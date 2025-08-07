package com.lsore.view;

import com.lsore.Main;
import com.lsore.enums.ColorType;
import com.lsore.enums.MessageType;

public class ConsoleView {

    private final ViewComponents viewComponents = new ViewComponents();

    // Displays the banner
    public void displayBanner() {
        viewComponents.printLine(ColorType.BLUE, 40);
        System.out.printf("%s        %s v%s%s%n", ColorType.MAGENTA.getColor(), Main.getAppConfig().getAppName(), Main.getAppConfig().getAppVersion(), ColorType.WHITE.getColor());
        System.out.printf("%s  Authored by Ludvik Macdonald Sørensen%n", ColorType.MAGENTA.getColor());
        System.out.printf("%s%s%n", ColorType.MAGENTA.getColor(), Main.getAppConfig().getGithubUrl());
        viewComponents.printLine(ColorType.BLUE, 41);
    }

    // Displays the main menu
    public void displayMainMenu() {
        viewComponents.printMessage(MessageType.INFORMATION, "Please select one of the following options!");
        viewComponents.menuOption(1, "Add Animal");
        viewComponents.menuOption(2, "List All Animals");
        viewComponents.menuOption(3, "Search Animals By Specie");
        viewComponents.menuOption(4, "Search Animals By Adoption Status");
        viewComponents.menuOption(5, "Update Animal Information");
        viewComponents.menuOption(6, "Remove an Animal by ID");
        viewComponents.menuOption(7, "Exit Application");
        viewComponents.menuOption(8, "Clear Console");
    }

    // Displays the sub menu for option 5
    public void displaySubMenu() {
        viewComponents.printMessage(MessageType.INFORMATION, "Please select one of the following options!");
        viewComponents.menuOption(1, "Update Adoption Status");
        viewComponents.menuOption(2, "Update Description");
        viewComponents.menuOption(4, "Update Benefits");
        viewComponents.menuOption(5, "Update Drawbacks");
        viewComponents.menuOption(6, "Return To Main Menu");
    }
}
