package CLI.User;

import Database.GenericSQLExecutor;
import Database.ExtractValue;

import java.util.List;
import java.util.Scanner;

public class ViewProfile {
    public static void userProfile(Scanner scanner, String idUser, String userName) {
        // Fetch all users pseudo and email
        List<GenericSQLExecutor.ResultSetRow> emailRows = GenericSQLExecutor.executeQuery("SELECT email FROM CLI.User WHERE id = ?", idUser);
        List<GenericSQLExecutor.ResultSetRow> pseudoRows = GenericSQLExecutor.executeQuery("SELECT pseudo FROM CLI.User WHERE id = ?", idUser);
        List<GenericSQLExecutor.ResultSetRow> storeIdRows = GenericSQLExecutor.executeQuery("SELECT store_id FROM CLI.User WHERE id = ?", idUser);

        if (emailRows == null || pseudoRows == null || storeIdRows == null || emailRows.isEmpty() || pseudoRows.isEmpty() || storeIdRows.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        // Print all whitelist user emails and pseudo
        for (int i = 0; i < emailRows.size(); i++) {
            String email = ExtractValue.extractValue(emailRows.get(i).toString());
            String pseudo = ExtractValue.extractValue(pseudoRows.get(i).toString());
            String storeId = ExtractValue.extractValue(storeIdRows.get(i).toString());
            System.out.println("Email: " + email + " | Pseudo : " + pseudo + " | Store ID : " + storeId);
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        UserProfile.reception(scanner, idUser, userName, false);
    }
}