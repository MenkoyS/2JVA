package Utils;

import java.util.Scanner;

public class LoginPageInteractions {

    public static String[] Login(Scanner scanner, boolean isGui) {
        System.out.println("Login Page");

        System.out.println("Enter your email: ");
        scanner.nextLine(); // Why ? => scanner is skipping the first input
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        return new String[]{email, password};
    }
}
