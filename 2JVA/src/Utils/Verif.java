package Utils;

import CLI.Admin.AdminProfile;
import Database.DatabaseUtils;
import CLI.User.UserProfile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Verif {

    public static void handleLogin(String email, Scanner scanner, boolean isGui) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE email = ?", email);
        String idUser = DatabaseUtils.fetchSingleColumnValue("SELECT id FROM User WHERE email = ?", email);
        String userName = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", email);

        if (isUser == null) {
            System.out.println("Error fetching user data.");
            return;
        }

        if (isUser.equals("true")) {
            handleUserLogin(scanner, idUser, userName, isGui);
        } else if (isUser.equals("false")) {
            handleAdminLogin(scanner, isGui);
        } else {
            System.out.println("Error: Invalid user type.");
        }
    }

    private static void handleUserLogin(Scanner scanner, String idUser, String userName, boolean isGui) {
        if (isGui) {
            // TODO: Implement GUI user profile
        } else {
            UserProfile.reception(scanner, idUser, userName, false);
        }
    }

    private static void handleAdminLogin(Scanner scanner, boolean isGui) {
        if (isGui) {
            // TODO: Implement GUI admin profile
        } else {
            AdminProfile.reception(scanner);
        }
    }

    public static void verifyAdmin(Scanner scanner, String idUser, String userName) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE id = ?", idUser);

        if (isUser == null) {
            System.out.println("Error fetching user data.");
            return;
        }

        if (isUser.equals("0")) {
            // UserProfile.main(scanner, idUser, userName);
        } else if (isUser.equals("1")) {
            AdminProfile.reception(scanner);
        } else {
            System.out.println("Error: Invalid user type.");
        }
    }

    public static int getValidEntry(int min, int max, Scanner scanner) {
        while (true) {
            try {
                int entry = scanner.nextInt();
                if (entry >= min && entry <= max) {
                    return entry;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
