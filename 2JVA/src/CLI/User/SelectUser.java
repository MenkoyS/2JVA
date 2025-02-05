package CLI.User;

import Database.GenericSQLExecutor;

import java.util.Scanner;
import java.util.List;

public class SelectUser {
    public static String findByPseudo(Scanner scanner) {
        System.out.println("Enter the user's pseudo: ");
        scanner.nextLine(); // buffer
        String pseudo = scanner.next();

        // Check if the pseudo exists
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", pseudo);

        if (rows != null && !rows.isEmpty()) {
            return pseudo;
        } else {
            System.out.println("Error: No user found with the provided pseudo.");
            return null;
        }
    }
    public static String findByEmail(Scanner scanner) {
        System.out.println("Enter the user's email: ");
        scanner.nextLine(); // buffer
        String email = scanner.next();

        // Check if the email exists
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ?", email);

        if (rows != null && !rows.isEmpty()) {
            return email;
        } else {
            System.out.println("Error: No user found with the provided email.");
            return null;
        }
    }
}
