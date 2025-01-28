import java.util.List;
import java.util.Scanner;

public class ViewWhitelist {
    public static void main(Scanner scanner, String idUser, String userName) {
        // Fetch all users storeId and email
        List<GenericSQLExecutor.ResultSetRow> emailRows = GenericSQLExecutor.executeQuery("SELECT email FROM Whitelist");
        List<GenericSQLExecutor.ResultSetRow> storeIdRows = GenericSQLExecutor.executeQuery("SELECT store_id FROM Whitelist");

        if (emailRows == null || storeIdRows == null || emailRows.isEmpty() || storeIdRows.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        // Print all whitelist user emails and storeId
        for (int i = 0; i < emailRows.size(); i++) {
            String email = ExtractValue.extractValue(emailRows.get(i).toString());
            String storeId = ExtractValue.extractValue(storeIdRows.get(i).toString());
            System.out.println("Email: " + email + " | Affiliation: " + storeId);
        }
        System.out.println();
        ManageWhitelist.main(scanner, idUser, userName);
    }
}