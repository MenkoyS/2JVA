package Admin;

import Utils.Verif;

import java.util.Scanner;

public class ManageWhitelist {
    public static void main(Scanner scanner) {
        System.out.println("Manage Whitelist");

        System.out.println("1. Add to Whitelist");
        System.out.println("2. Remove from Whitelist");
        System.out.println("3. View Whitelist");
        System.out.println("4. Go back");

        System.out.println("Please enter your choice: ");
        int choice = Verif.isEntryValid(1, 4, scanner);

        switch (choice) {
            case 1:
                AddToWhitelist.main(scanner);
            case 2:
                RemoveFromWhitelist.main(scanner);
            case 3:
                ViewWhitelist.main(scanner);
                break;
            case 4:
                AdminProfile.main(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}
