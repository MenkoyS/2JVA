package CLI.User;

import Utils.Verif;

import java.util.Scanner;

public class DeleteProfile {
    public static void deleteUser(Scanner scanner, String idUser, String userName) {
        System.out.println("Are you sure you want to delete your profile? ");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.println("Please enter your choice: ");
        int choice = Verif.getValidEntry(1, 2, scanner);

        switch (choice) {
            case 1 -> DeleteProfileVerify.deleteUser(scanner);
            case 2 -> UserProfile.reception(scanner, idUser, userName, false);
            default -> System.out.println("Invalid choice");
        }
    }
}