package Menus;

import Utils.Verif;

import java.util.Scanner;

public class GuiMenu {
    public static void main(Scanner scanner) {

        System.out.println("Would you like to login or to register ?");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Go back");

        System.out.println("Enter your choice: ");


        int choice = Verif.isEntryValid(1, 3, scanner);

        switch (choice) {
            case 1:
                LoginPage.main(scanner);
                break;
            case 2:
                RegisterPage.main(scanner);
                break;
            case 3:
                WelcomeMenu.main(scanner);
                break;
            default:
                GuiMenu.main(scanner);
                break;
        }
    }
}