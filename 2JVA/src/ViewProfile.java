import java.util.List;
import java.util.Scanner;

public class ViewProfile {
    public static void main(Scanner scanner, String[] args) {
        // Fetch all users pseudo and email
        int id = 7;
        List<GenericSQLExecutor.ResultSetRow> emailRows = GenericSQLExecutor.executeQuery("SELECT email FROM User WHERE id = ?", id);
        List<GenericSQLExecutor.ResultSetRow> pseudoRows = GenericSQLExecutor.executeQuery("SELECT pseudo FROM User WHERE id = ?", id);
        List<GenericSQLExecutor.ResultSetRow> storeIdRows = GenericSQLExecutor.executeQuery("SELECT store_id FROM User WHERE id = ?", id);

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
        scanner.nextLine();// Need 2 next lines to work
        scanner.nextLine();
        UserProfile.main(args);
    }
}