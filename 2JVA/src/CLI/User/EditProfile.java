package CLI.User;

import Utils.Verif;
import java.util.Scanner;

public class EditProfile {
    public static void editUser(Scanner scanner, String idUser, String userName) {
            System.out.println("Edit Profile:");
            displayMenu();
            handleUserChoice(scanner, idUser, userName);
    }

    private static void displayMenu() {
        System.out.println("1. Change pseudo");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Return to User menu");
        System.out.print("Please enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner, String idUser, String userName) {
        int choice = Verif.getValidEntry(1, 4, scanner);
        switch (choice) {
            case 1 -> EditInfo.changePseudo(scanner, idUser, userName);
            case 2 -> EditInfo.changeEmail(scanner, idUser, userName);
            case 3 -> EditInfo.changePassword(scanner, idUser, userName);
            case 4 -> {
                UserProfile.reception(scanner, idUser, userName);
                return;
            }
            default -> System.out.println("Invalid choice, please try again.");
        }
    }
}