package CLI.User;

import Database.GenericSQLExecutor;
import CLI.Menus.LoginPage;
import Utils.Verif;

import java.util.Scanner;

public class CreateNewUserManager {
    public static void addUserToDatabase(String email, String pseudo, String password) {
        GenericSQLExecutor.executeQuery("INSERT INTO CLI.User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)", email, pseudo, password, 1);
    }

    public static void redirection(Scanner scanner, String idUser, String userName) {
        System.out.println("Do you want to go to the login page ?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = Verif.getValidEntry(1, 2, scanner);

        switch (choice) {
            case 1:
                LoginPage.cli(scanner);
                break;
            case 2:
                UserProfile.reception(scanner, idUser, userName, false);
                break;
            default:
                System.out.println("Invalid choice, returning to the profile menu");
                UserProfile.reception(scanner, idUser, userName, false);
        }
    }
}