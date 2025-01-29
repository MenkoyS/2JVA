package Admin;

import User.SelectUser;
import Utils.Verif;

import java.util.Scanner;

public class ManageUsers {
    public static void main(Scanner scanner) {
        System.out.println("Find an user to edit:");

        System.out.println("1. Find by pseudo");
        System.out.println("2. Find by email");
        System.out.println("3. Go back");

        int choice = Verif.isEntryValid(1, 3, scanner);

        switch (choice) {
            case 1:
                String pseudo = SelectUser.FindByPseudo(scanner);
                if (pseudo != null) {
                    AskEdit.main(scanner, pseudo);
                }
                else {
                    AdminProfile.main(scanner);
                }
                break;
            case 2:
                String email = SelectUser.FindByEmail(scanner);
                if (email != null) {
                    AskEdit.main(scanner, email);
                }
                else {
                    AdminProfile.main(scanner);
                }
                break;
            case 3:
                AdminProfile.main(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                ManageUsers.main(scanner);
                break;
        }
    }
}