package User;

import Utils.Verif;

import java.util.Scanner;

public class DeleteProfile {
    public static void main(Scanner scanner, String idUser, String userName) {
        System.out.println("Are you sure you want to delete your profile? ");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.println("Please enter your choice: ");
        int choice = Verif.isEntryValid(1, 2, scanner);

        switch (choice) {
            case 1:
                DeleteProfileVerify.main(scanner, idUser, userName);
                break;
            case 2:
                UserProfile.main(scanner, idUser, userName, false);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}