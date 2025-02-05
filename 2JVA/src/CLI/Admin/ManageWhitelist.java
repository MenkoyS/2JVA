package CLI.Admin;

import Utils.Verif;
import java.util.Scanner;

public class ManageWhitelist {
    public static void reception(Scanner scanner) {
        System.out.println("Manage Whitelist");
        displayMenu();
        handleUserChoice(scanner);
    }

    private static void displayMenu() {
        System.out.println("1. Add to Whitelist");
        System.out.println("2. Remove from Whitelist");
        System.out.println("3. View Whitelist");
        System.out.println("4. Go back");
        System.out.print("Please enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner) {
        int choice = Verif.getValidEntry(1, 4, scanner);
        switch (choice) {
            case 1 -> AddToWhitelist.addUser(scanner);
            case 2 -> RemoveFromWhitelist.removeUser(scanner);
            case 3 -> ViewWhitelist.infoWhitelist(scanner);
            case 4 -> AdminProfile.reception(scanner);
            default -> {
                System.out.println("Invalid choice, please try again.");
                reception(scanner);
            }
        }
    }
}