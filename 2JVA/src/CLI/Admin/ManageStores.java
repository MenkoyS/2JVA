package CLI.Admin;

import Utils.Verif;
import java.util.Scanner;

public class ManageStores {
    public static void reception(Scanner scanner) {
        System.out.println("Manage Stores");
        displayMenu();
        handleUserChoice(scanner);
    }

    private static void displayMenu() {
        System.out.println("1. Add a store");
        System.out.println("2. Remove a store");
        System.out.println("3. Show all stores");
        System.out.println("4. Back to Admin Profile");
        System.out.print("Please enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner) {
        int choice = Verif.getValidEntry(1, 4, scanner);
        switch (choice) {
            case 1 -> EditStore.addStore(scanner);
            case 2 -> EditStore.removeStore(scanner);
            case 3 -> ShowStores.main(scanner);
            case 4 -> AdminProfile.reception(scanner);
            default -> {
                System.out.println("Invalid choice, please try again.");
                reception(scanner);
            }
        }
    }
}
