package CLI.User;

import CLI.Common.PrintInventory;
import CLI.Common.UserSearch;
import Utils.Verif;

import java.util.Scanner;

public class UserProfile {
    public static void reception(Scanner scanner, String idUser, String userName) {
        greetUser(userName);
        displayMenu();
        handleUserChoice(Verif.getValidEntry(1, 7, scanner), scanner, idUser, userName);
    }

    private static void greetUser(String userName) {
        System.out.println("Hello " + userName + " !");
        System.out.println("Welcome to your profile!");
    }

    private static void displayMenu() {
        System.out.println("1. See the inventory");
        System.out.println("2. View Profile");
        System.out.println("3. Edit Profile");
        System.out.println("4. Search for a user");
        System.out.println("5. Create a new account");
        System.out.println("6. Logout");
        System.out.println("7. Delete Profile");
        System.out.print("Please enter your choice: ");
    }

    private static void handleUserChoice(int choice, Scanner scanner, String idUser, String userName) {
        switch (choice) {
            case 1 -> PrintInventory.viewInventory(scanner, idUser, userName);
            case 2 -> ViewProfile.userProfile(scanner, idUser, userName);
            case 3 -> EditProfile.editUser(scanner, idUser, userName);
            case 4 -> UserSearch.searchUser(scanner, idUser, userName);
            case 5 -> CreateNewUser.userCreation(scanner, idUser, userName);
            case 6 -> logout();
            case 7 -> DeleteProfile.deleteUser(scanner, idUser, userName);
            default -> System.out.println("Invalid choice");
        }
    }

    private static void logout() {
        System.out.println("You have been logged out successfully.");
    }
}