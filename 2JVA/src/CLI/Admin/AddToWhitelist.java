package CLI.Admin;

import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class AddToWhitelist {

    public static void addUser(Scanner scanner) {
        String email = getConfirmedInput(scanner);

        if (isEmailTaken(email)) {
            System.out.println("Email is already in the whitelist.");
            ManageWhitelist.reception(scanner);
            return;
        }

        int storeId = chooseStore(scanner);
        confirmAndAddToWhitelist(scanner, email, storeId);
    }

    private static String getConfirmedInput(Scanner scanner) {
        scanner.nextLine(); // Clear the buffer
        while (true) {
            System.out.print("Enter the " + "email" + ": ");
            String input1 = scanner.nextLine().trim();

            if (input1.isEmpty()) {
                System.out.println("email" + " cannot be empty. Please try again.");
                continue;
            }

            System.out.print("Confirm the " + "email" + ": ");
            String input2 = scanner.nextLine().trim();

            if (input1.equals(input2)) {
                return input1;
            } else {
                System.out.println("email" + "s do not match. Please try again.");
            }
        }
    }

    private static boolean isEmailTaken(String email) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery(
                "SELECT email FROM Whitelist WHERE email = ?", email);
        return rows != null && !rows.isEmpty();
    }

    private static int chooseStore(Scanner scanner) {
        System.out.println("Here are all the stores:");
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM Store");

        if (rows != null) {
            for (GenericSQLExecutor.ResultSetRow row : rows) {
                System.out.println(row);
            }
        }

        System.out.print("Enter the store ID: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid store ID: ");
            scanner.next();
        }
        int storeId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        return storeId;
    }

    private static void confirmAndAddToWhitelist(Scanner scanner, String email, int storeId) {
        System.out.println("Here are the details:");
        System.out.println("Email: " + email);
        System.out.println("Store ID: " + storeId);

        System.out.println("Confirm adding " + email + " to store " + storeId + ":");
        System.out.println("1. Yes\n2. No\n3. Go back");

        int choice = Verif.getValidEntry(1, 3, scanner);

        switch (choice) {
            case 1 -> {
                GenericSQLExecutor.executeQuery("INSERT INTO Whitelist (email, store_id) VALUES (?, ?)", email, storeId);
                System.out.println("Added to Whitelist.");
            }
            case 2 -> System.out.println("Not added to Whitelist.");
            case 3 -> System.out.println("Going back to the previous menu.");
            default -> System.out.println("Invalid choice. Returning to the main menu.");
        }
        ManageWhitelist.reception(scanner);
    }
}