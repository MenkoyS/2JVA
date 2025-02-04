package Menus;

import Swing.WelcomePage;
import Utils.Verif;

import java.util.Scanner;

public class WelcomeMenu {
    public static void main(Scanner scanner) {
        System.out.println("Hello");

        System.out.println("Would you like to launch the app using CLI or Swing GUI ?");

        System.out.println("1. CLI");
        System.out.println("2. Swing GUI");
        System.out.println("3. Exit");

        boolean isGui;
        int choice = Verif.isEntryValid(1, 3, scanner);

        switch (choice) {
            case 1:
                CliMenu.main(scanner, false);
                break;
            case 2:
                WelcomePage.displayWelcomePage(1200, 800);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
