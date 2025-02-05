package CLI.Admin;

import Database.GenericSQLExecutor;
import Database.ExtractValue;

import java.util.List;
import java.util.Scanner;

public class ShowStores {
    public static void main(Scanner scanner) {
        List<GenericSQLExecutor.ResultSetRow> stores = GenericSQLExecutor.executeQuery("SELECT name FROM Store");

        if (stores == null || stores.isEmpty()) {
            System.out.println("No stores found");
        } else {
            System.out.println("Stores:");
            for (GenericSQLExecutor.ResultSetRow store : stores) {
                String storeName = ExtractValue.extractValue(store.toString());
                System.out.println(storeName);
            }
        }
        ManageStores.reception(scanner);
    }
}
