import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(Scanner scanner ) {
        System.out.println("Please Login before accessing the Inventory");

        System.out.println("Enter your pseudo: ");
        String pseudo = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // do a query that looks in the User table and look for the password of the user with the pseudo
        List<GenericSQLExecutor.ResultSetRow> doPasswordMatch = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ? AND password = ?", pseudo, password);

        if (doPasswordMatch == null || doPasswordMatch.isEmpty()) {
            System.out.println("Invalid credentials");
            System.exit(1);
        }

        List<GenericSQLExecutor.ResultSetRow> isAdmin = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ? AND isUser = ?", pseudo, 0);

        if (isAdmin == null || isAdmin.isEmpty()) {
            String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE pseudo = ?", pseudo);
            UserInventory.main(scanner, storeId);
        } else {
            InventorySelection.main(scanner);
        }
    }
}