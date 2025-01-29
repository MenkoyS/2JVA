package User;

import Database.GenericSQLExecutor;

import java.util.Scanner;
import java.util.List;

public class SelectUser {
    public static String FindByPseudo(Scanner scanner) {
        System.out.println("Enter the user's pseudo: ");
        scanner.nextLine(); // buffer
        String pseudo = scanner.next();

        // Check if the pseudo exists
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", pseudo);

        if (rows != null && !rows.isEmpty()) {
            System.out.println("User found: " + rows);
            return pseudo;
        } else {
            System.out.println("Error: No user found with the provided pseudo.");
            return null;
        }
    }
    public static String FindByEmail(Scanner scanner) {
        System.out.println("Enter the user's email: ");
        scanner.nextLine(); // buffer
        String email = scanner.next();

        // Check if the email exists
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ?", email);

        if (rows != null && !rows.isEmpty()) {
            System.out.println("User found: " + rows);
            return email;
        } else {
            System.out.println("Error: No user found with the provided email.");
            return null;
        }
    }
}
