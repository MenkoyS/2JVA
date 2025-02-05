package CLI.Menus;

import Swing.WelcomePage;
import Utils.RegisterPageInteractions;
import Utils.RegisterPageVerify;
import Utils.Verif;

import java.util.Scanner;

public class RegisterPage {
    public static void cli(Scanner scanner) {
        String[] userDetails = RegisterPageInteractions.Register(scanner);
        RegisterPageVerify.verify(userDetails);

        displaySuccessMessage();
        handlePostRegistrationChoice(scanner);
    }

    private static void displaySuccessMessage() {
        System.out.println("You have successfully registered");
        System.out.println("Would you like to login now?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    private static void handlePostRegistrationChoice(Scanner scanner) {
        int choice = Verif.getValidEntry(1, 2, scanner);

        switch (choice) {
            case 1 -> redirectToLogin(scanner);
            case 2 -> redirectToWelcomeMenu(scanner);
            default -> System.out.println("Invalid choice");
        }
    }

    private static void redirectToLogin(Scanner scanner) {
        System.out.println("Redirecting you to the login page...");
        LoginPage.cli(scanner);
    }

    private static void redirectToWelcomeMenu(Scanner scanner) {
        System.out.println("Redirecting you to the welcome menu...");
        WelcomeMenu.launch(scanner);
    }
}