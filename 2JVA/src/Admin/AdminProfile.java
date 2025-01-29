package Admin;

import Menus.WelcomeMenu;
import Utils.Verif;

import java.util.Scanner;

public class AdminProfile {
    public static void main(Scanner scanner) {

        System.out.println("Hello Admin !");

        System.out.println("Welcome to your profile ! ");
        System.out.println("1. Manage the inventory");
        System.out.println("2. Manage Users");
        System.out.println("3. Manage Whitelist");
        System.out.println("4  Manage Stores");
        System.out.println("5. Logout");

        System.out.println("Please enter your choice: ");
        int choice = Verif.isEntryValid(1, 5, scanner);

        switch (choice) {
            case 1:
                InventorySelection.main(scanner);
                break;
            case 2:
                ManageUsers.main(scanner);
                break;
            case 3:
                ManageWhitelist.main(scanner);
                break;
            case 4:
                ManageStores.main(scanner);
                break;
            case 5:
                WelcomeMenu.main(scanner);
                break;
            default:
                System.out.println("Invalid choice");
                AdminProfile.main(scanner);
                break;
        }
    }
}
