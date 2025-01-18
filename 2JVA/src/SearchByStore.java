import java.util.List;
import java.util.Scanner;

public class SearchByStore {

    public static void searchByStore(Scanner scanner) {
        System.out.println("Enter the store name for affiliation: ");
        scanner.nextLine(); // Consume the /n character
        String storeName = scanner.nextLine();

        // Get store_id for the given store name
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM Store WHERE name = ?", storeName);

        if (storeId == null) {
            System.out.println("Store not found.");
            return;
        }

        // Fetch all users pseudo and email for the given store_id
        List<GenericSQLExecutor.ResultSetRow> emailRows = GenericSQLExecutor.executeQuery("SELECT email FROM User WHERE store_id = ?", storeId);
        List<GenericSQLExecutor.ResultSetRow> pseudoRows = GenericSQLExecutor.executeQuery("SELECT pseudo FROM User WHERE store_id = ?", storeId);

        if (emailRows == null || pseudoRows == null || emailRows.isEmpty() || pseudoRows.isEmpty()) {
            System.out.println("No users affiliated with this store.");
            return;
        }

        // Print all user emails and pseudo associated with the store
        for (int i = 0; i < emailRows.size(); i++) {
            String email = ExtractValue.extractValue(emailRows.get(i).toString());
            String pseudo = ExtractValue.extractValue(pseudoRows.get(i).toString());
            System.out.println("Email: " + email + " | Pseudo: " + pseudo + " | Affiliation: " + storeName);
        }
    }
}
