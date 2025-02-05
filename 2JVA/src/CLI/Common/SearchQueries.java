package CLI.Common;

import CLI.User.UserProfile;
import Database.DatabaseUtils;
import Database.ExtractValue;
import Database.GenericSQLExecutor;

import java.util.List;
import java.util.Scanner;

public class SearchQueries {
    public static void searchUser(int choice, Scanner scanner, String idUser, String userName) {
        switch (choice) {
            case 1 -> searchByUsername(scanner, userName);
            case 2 -> searchByEmail(scanner, userName);
            case 3 -> searchByStore(scanner, userName);
            case 4 -> UserProfile.reception(scanner, idUser, userName);
            default -> System.out.println("Invalid choice, please try again.");
        }
    }

    public static void searchByUsername(Scanner scanner, String userName) {
        System.out.println("Enter the username (pseudo): ");
        scanner.nextLine();
        String userPseudo = scanner.nextLine();

        String pseudo = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE pseudo = ?", userPseudo);
        String email = DatabaseUtils.fetchSingleColumnValue("SELECT email FROM User WHERE pseudo = ?", userPseudo);
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE pseudo = ?", userPseudo);

        if (storeId == null || pseudo == null || email == null) {
            System.out.println("User not found or incomplete data.");
            UserProfile.reception(scanner, userName, userName);
            return;
        }

        String storeName = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Store WHERE store_id = ?", storeId);
        System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);
        UserProfile.reception(scanner, userName, userName);
    }

    public static void searchByEmail(Scanner scanner, String userName) {
        System.out.println("Enter the email address: ");
        scanner.nextLine();
        String userEmail = scanner.nextLine();

        String email = DatabaseUtils.fetchSingleColumnValue("SELECT email FROM User WHERE email = ?", userEmail);
        String pseudo = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", userEmail);
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE email = ?", userEmail);

        if (email == null || pseudo == null || storeId == null) {
            System.out.println("Email not found or incomplete data.");
            UserProfile.reception(scanner, userName, userName);
            return;
        }

        String storeName = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Store WHERE store_id = ?", storeId);
        System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);
        UserProfile.reception(scanner, userName, userName);
    }

    public static void searchByStore(Scanner scanner, String userName) {
        System.out.println("Enter the store name for affiliation: ");
        scanner.nextLine();
        String storeName = scanner.nextLine();

        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM Store WHERE name = ?", storeName);

        if (storeId == null) {
            System.out.println("Store not found.");
            UserProfile.reception(scanner, userName, userName);
            return;
        }

        List<GenericSQLExecutor.ResultSetRow> emailRows = GenericSQLExecutor.executeQuery("SELECT email FROM User WHERE store_id = ?", storeId);
        List<GenericSQLExecutor.ResultSetRow> pseudoRows = GenericSQLExecutor.executeQuery("SELECT pseudo FROM User WHERE store_id = ?", storeId);

        if (emailRows == null || pseudoRows == null || emailRows.isEmpty() || pseudoRows.isEmpty()) {
            System.out.println("No users affiliated with this store.");
            UserProfile.reception(scanner, userName, userName);
            return;
        }

        for (int i = 0; i < emailRows.size(); i++) {
            String email = ExtractValue.extractValue(emailRows.get(i).toString());
            String pseudo = ExtractValue.extractValue(pseudoRows.get(i).toString());
            System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);
        }
        UserProfile.reception(scanner, userName, userName);
    }
}