package Common;

import Database.DatabaseUtils;

import java.util.Scanner;

public class SearchByEmail {

    public static void searchByEmail(Scanner scanner) {
        System.out.println("Enter the email address: ");
        scanner.nextLine(); // Consume the /n character
        String userEmail = scanner.nextLine();

        // Fetch user details
        String email = DatabaseUtils.fetchSingleColumnValue("SELECT email FROM User WHERE email = ?", userEmail);
        String pseudo = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", userEmail);
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE email = ?", userEmail);

        if (email == null || pseudo == null || storeId == null) {
            System.out.println("Email not found or incomplete data.");
            return;
        }

        // Fetch store name
        String storeName = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Store WHERE store_id = ?", storeId);

        System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);
    }
}
