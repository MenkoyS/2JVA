package Utils;

import java.util.Scanner;

public class RegisterPageInteractions {

    public static String[] Register(Scanner scanner) {

        System.out.println("Register Page");

        System.out.println("Enter your pseudo: ");
        scanner.nextLine(); // Why ? => scanner is skipping the first input
        String pseudo = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Enter your password again: ");
        String passwordAgain = scanner.nextLine();

        return new String[]{pseudo, email, password, passwordAgain};
    }
}
