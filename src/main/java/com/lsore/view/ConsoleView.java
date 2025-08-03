package com.lsore.view;

import com.lsore.Main;
import com.lsore.utils.Colors;

public class ConsoleView {

    private final Colors colors = new Colors();

    // Displays the banner
    public void displayBanner() {
        System.out.printf("%s────────────────────────────────────────%s%n", colors.getBlue(), colors.getReset());
        System.out.printf("%s        %s v%s%s%n", colors.getMagenta(), Main.getAppConfig().getAppName(), Main.getAppConfig().getAppVersion(), colors.getWhite());
        System.out.printf("%s  Authored by Ludvik Macdonald Sørensen%n", colors.getMagenta());
        System.out.printf("%s%s%n", colors.getMagenta(), Main.getAppConfig().getGithubUrl());
        System.out.printf("%s─────────────────────────────────────────%s", colors.getBlue(), colors.getWhite());
    }

    // Displays the main menu
    public void displayMainMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sAdd Animal%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sList All Animals%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[3]%s - %sSearch Animals by Specie%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[4]%s - %sSearch Animals by Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[5]%s - %sUpdate Animal Information%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[6]%s - %sRemove Animal by ID%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[7]%s - %sExit Program%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[8]%s - %sClear Console%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

    // Displays the sub menu for option 5
    public void displaySubMenu() {
        System.out.println(colors.getGreen() + "\nPlease select one of the following options!" + colors.getWhite());
        System.out.printf("%s[1]%s - %sUpdate Adoption Status%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[2]%s - %sUpdate Description%n", colors.getGreen(), colors.getGray(), colors.getWhite());
        System.out.printf("%s[3]%s - %sUpdate Benefits%n", colors.getGreen(), colors.getGray(), colors.getWhite()); // TODO: Implement logic
        System.out.printf("%s[4]%s - %sUpdate Drawbacks%n", colors.getGreen(), colors.getGray(), colors.getWhite()); // TODO: Implement logic
        System.out.printf("%s[7]%s - %sReturn to main menu%n\n", colors.getGreen(), colors.getGray(), colors.getWhite());
    }

}
