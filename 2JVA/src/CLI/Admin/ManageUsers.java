package CLI.Admin;

import CLI.User.SelectUser;
import Utils.Verif;

import java.util.Scanner;

public class ManageUsers {
    public static void menu(Scanner scanner) {
        System.out.println("Find a user to edit:");
        System.out.println("1. Find by pseudo");
        System.out.println("2. Find by email");
        System.out.println("3. Go back");

        int choice = Verif.getValidEntry(1, 3, scanner);

        if (choice == 1 || choice == 2) {
            String userIdentifier = (choice == 1) ? SelectUser.findByPseudo(scanner) : SelectUser.findByEmail(scanner);
            if (userIdentifier != null) {
                AskEdit.editReception(scanner, userIdentifier);
            } else {
                AdminProfile.reception(scanner);
            }
        } else if (choice == 3) {
            AdminProfile.reception(scanner);
        } else {
            System.out.println("Invalid choice. Please try again.");
            menu(scanner);
        }
    }
}
