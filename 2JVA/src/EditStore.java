import java.util.List;
import java.util.Scanner;

public class EditStore {
    public static void AddStore(Scanner scanner, String idUser, String userName) {
        System.out.println("What is the name of the new store?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT name FROM Store WHERE name = ?", storeName);

        if (stores != null && !stores.isEmpty()) {
            System.out.println("Store already exists");
            AddStore(scanner, idUser, userName);
        } else {
            GenericSQLExecutor.executeQuery("INSERT INTO Store (name) VALUES (?)", storeName);
            System.out.println("Store added successfully");
            ManageStores.main(scanner, idUser, userName);
    }
}
    public static void RemoveStore(Scanner scanner, String idUser, String userName) {
        System.out.println("What is the name of the store to remove?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT * FROM Store WHERE name = ?", storeName);

        if (stores == null || stores.isEmpty()) {
            System.out.println("Store does not exist");
            RemoveStore(scanner, idUser, userName);
        } else {
            GenericSQLExecutor.executeQuery("DELETE FROM Store WHERE name = ?", storeName);
            System.out.println("Store removed successfully");
            ManageStores.main(scanner, idUser, userName);
        }
    }
}
