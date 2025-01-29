package User;

import Database.GenericSQLExecutor;
import Menus.LoginPage;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class CreateNewUserManager {
    public static void AddUserToDatabase(String email, String pseudo, String password) {
        GenericSQLExecutor.executeQuery("INSERT INTO User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)", email, pseudo, password, 1);
    }

    public static void Redirection(Scanner scanner, String idUser, String userName) {
        System.out.println("Do you want to go to the login page ?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = Verif.isEntryValid(1, 2, scanner);

        switch (choice) {
            case 1:
                LoginPage.main(scanner);
                break;
            case 2:
                UserProfile.main(scanner, idUser, userName);
                break;
            default:
                System.out.println("Invalid choice, returning to the profile menu");
                UserProfile.main(scanner, idUser, userName);
        }
    }
}