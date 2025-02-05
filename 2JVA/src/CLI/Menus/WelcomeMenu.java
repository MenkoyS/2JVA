package CLI.Menus;

import Swing.WelcomePage;
import Utils.Verif;

import java.util.Scanner;

public class WelcomeMenu {
    public static void launch(Scanner scanner) {
        greetUser();
        displayMenu();
        handleUserChoice(Verif.getValidEntry(1, 3, scanner), scanner);
    }

    private static void greetUser() {
        System.out.println("Hello");
    }

    private static void displayMenu() {
        System.out.println("Would you like to launch the app using CLI or Swing GUI ?");
        System.out.println("1. CLI");
        System.out.println("2. Swing GUI");
        System.out.println("3. Exit");
    }

    private static void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1 -> CliMenu.menu(scanner);
            case 2 -> WelcomePage.displayWelcomePage(1200, 800);
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid choice");
        }
    }
}