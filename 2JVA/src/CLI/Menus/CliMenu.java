package CLI.Menus;

import Utils.Verif;

import java.util.Scanner;

public class CliMenu {
    public static void menu(Scanner scanner) {
        displayMenu();
        handleUserChoice(scanner);
    }

    private static void displayMenu() {
        System.out.println("Would you like to login or to register?");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Go back");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner) {
        int choice = Verif.getValidEntry(1, 3, scanner);

        switch (choice) {
            case 1 -> LoginPage.cli(scanner);
            case 2 -> RegisterPage.cli(scanner);
            case 3 -> WelcomeMenu.launch(scanner);
            default -> menu(scanner);
        }
    }
}