package Menus;

import Utils.RegisterPageInteractions;
import Utils.RegisterPageVerify;
import Utils.Verif;

import java.util.Scanner;

public class RegisterPage {
    public static void main(Scanner scanner, boolean isGui) {
        String[] userDetails = RegisterPageInteractions.Register(scanner);

        RegisterPageVerify.verify(scanner, userDetails);

        System.out.println("You have successfully registered");
        System.out.println("Would you like to login now ?");

        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = Verif.isEntryValid(1, 2, scanner);

        if (choice == 1) {
            System.out.println("Redirecting you to the login page...");
            LoginPage.main(scanner, false);
        } else if (choice == 2) {
            System.out.println("Redirecting you to the welcome menu...");
            // TEMPORARY
        } else {
            System.out.println("Invalid choice");
        }
    }
}