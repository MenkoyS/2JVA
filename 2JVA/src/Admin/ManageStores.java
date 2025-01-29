package Admin;

import Utils.Verif;

import java.util.Scanner;

public class ManageStores {
    public static void main(Scanner scanner) {
        System.out.println("Manage Stores");

        System.out.println("1. Add a store");
        System.out.println("2. Remove a store");
        System.out.println("3. Show all stores");
        System.out.println("4. Back to Admin Profile");

        System.out.println("Please enter your choice: ");
        int choice = Verif.isEntryValid(1, 4, scanner);

        switch (choice) {
            case 1:
                EditStore.AddStore(scanner);
                break;
            case 2:
                EditStore.RemoveStore(scanner);
                break;
            case 3:
                ShowStores.main(scanner);
                break;
            case 4:
                AdminProfile.main(scanner);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}