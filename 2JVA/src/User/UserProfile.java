package User;

import Common.PrintInventory;
import Common.UserSearch;
import Utils.Verif;

import java.util.Scanner;

public class UserProfile {
    public static void main(Scanner scanner, String idUser, String userName) {
        System.out.println("Hello " + userName + " !");

        System.out.println("Welcome to your profile ! ");
        System.out.println("1. See the inventory");
        System.out.println("2. View Profile");
        System.out.println("3. Edit Profile");
        System.out.println("4. Search for a user");
        System.out.println("5. Create a new account");
        System.out.println("6. Logout");
        System.out.println("7. Delete Profile");

        System.out.println("Please enter your choice: ");
        int choice = Verif.isEntryValid(1, 7, scanner);

        switch (choice) {
            case 1:
                PrintInventory.main(scanner, idUser, userName);
                break;
            case 2:
                ViewProfile.main(scanner, idUser, userName);
                break;
            case 3:
                EditProfile.main(scanner, idUser, userName);
                break;
            case 4:
                UserSearch.main(scanner, idUser, userName);
                break;
            case 5:
                CreateNewUser.main(scanner, idUser, userName);
                break;
            case 6:
                // BYE BYE
                break;
            case 7:
                DeleteProfile.main(scanner, idUser, userName);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
