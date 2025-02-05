package CLI.User;

import Utils.CreateNewUserVerify;

import java.util.Scanner;

public class CreateNewUser {
    public static void userCreation(Scanner scanner, String idUser, String userName) {

        System.out.println("Enter the email: ");
        String email = scanner.nextLine();

        CreateNewUserVerify.isWhitelist(email, scanner);

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Confirm your password: ");
        String confirmPassword = scanner.nextLine();

        CreateNewUserVerify.isPasswordCorresponding(password, confirmPassword, scanner);

        System.out.println("Enter your pseudo: ");
        String pseudo = scanner.nextLine();

        CreateNewUserVerify.isPseudoAvailable(pseudo, scanner);

        CreateNewUserManager.addUserToDatabase(email, pseudo, password);

        CreateNewUserManager.redirection(scanner, idUser, userName);

        }
    }