import java.util.List;
import java.util.Scanner;

public class EditStore {
    public static void AddStore(Scanner scanner) {
        System.out.println("What is the name of the new store?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT name FROM Store WHERE name = ?", storeName);

        if (stores != null && !stores.isEmpty()) {
            System.out.println("Store already exists");
        } else {
            GenericSQLExecutor.executeQuery("INSERT INTO Store (name) VALUES (?)", storeName);
            System.out.println("Store added successfully");
    }
}
    public static void RemoveStore(Scanner scanner) {
        System.out.println("What is the name of the store to remove?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT * FROM Store WHERE name = ?", storeName);

        if (stores == null || stores.isEmpty()) {
            System.out.println("Store does not exist");
        } else {
            GenericSQLExecutor.executeQuery("DELETE FROM Store WHERE name = ?", storeName);
            System.out.println("Store removed successfully");
        }
    }
}
