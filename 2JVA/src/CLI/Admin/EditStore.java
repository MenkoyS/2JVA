package CLI.Admin;

import Database.GenericSQLExecutor;

import java.util.List;
import java.util.Scanner;

public class EditStore {
    public static void addStore(Scanner scanner) {
        System.out.println("What is the name of the new store?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT name FROM Store WHERE name = ?", storeName);

        if (stores != null && !stores.isEmpty()) {
            System.out.println("Store already exists");
            addStore(scanner);
        } else {
            GenericSQLExecutor.executeQuery("INSERT INTO Store (name) VALUES (?)", storeName);
            System.out.println("Store added successfully");
            ManageStores.reception(scanner);
    }
}
    public static void removeStore(Scanner scanner) {
        System.out.println("What is the name of the store to remove?");
        scanner.nextLine(); // buffer
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT * FROM Store WHERE name = ?", storeName);

        if (stores == null || stores.isEmpty()) {
            System.out.println("Store does not exist");
            ManageStores.reception(scanner);
        } else {
            GenericSQLExecutor.executeQuery("DELETE FROM Store WHERE name = ?", storeName);
            System.out.println("Store removed successfully");
            ManageStores.reception(scanner);
        }
    }
}
