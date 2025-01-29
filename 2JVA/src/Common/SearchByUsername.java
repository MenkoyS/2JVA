package Common;

import Database.DatabaseUtils;

import java.util.Scanner;

public class SearchByUsername {

    public static void searchByUsername(Scanner scanner) {
        System.out.println("Enter the username (pseudo): ");
        scanner.nextLine(); // Consume the /n character
        String userPseudo = scanner.nextLine();

        // Fetch user details
        String pseudo = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE pseudo = ?", userPseudo);
        String email = DatabaseUtils.fetchSingleColumnValue("SELECT email FROM User WHERE pseudo = ?", userPseudo);
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE pseudo = ?", userPseudo);

        if (storeId == null || pseudo == null || email == null) {
            System.out.println("User not found or incomplete data.");
            return;
        }

        // Fetch store name
        String storeName = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Store WHERE store_id = ?", storeId);

        System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);


    }
}
