package CLI.Admin;

import CLI.Menus.WelcomeMenu;
import Utils.Verif;

import java.util.Scanner;

public class AdminProfile {
    public static void reception(Scanner scanner) {
        System.out.println("Hello Admin!");
        System.out.println("Welcome to your profile!");
        displayMenu();
        handleUserChoice(scanner);
    }

    private static void displayMenu() {
        System.out.println("1. Manage the inventory");
        System.out.println("2. Manage Users");
        System.out.println("3. Manage Whitelist");
        System.out.println("4. Manage Stores");
        System.out.println("5. Logout");
        System.out.println("Please enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner) {
        int choice = Verif.getValidEntry(1, 5, scanner);
        switch (choice) {
            case 1 -> InventorySelection.selectInventory(scanner);
            case 2 -> ManageUsers.menu(scanner);
            case 3 -> ManageWhitelist.reception(scanner);
            case 4 -> ManageStores.reception(scanner);
            case 5 -> WelcomeMenu.launch(scanner);
            default -> {
                System.out.println("Invalid choice");
                reception(scanner);
            }
        }
    }
}
