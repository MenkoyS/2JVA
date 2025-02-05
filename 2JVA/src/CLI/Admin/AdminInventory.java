package CLI.Admin;

import CLI.Common.EditItem;
import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class AdminInventory {
    public static void manageStoreInventory(Scanner scanner, String storeId) {

        List<GenericSQLExecutor.ResultSetRow> inventory = GenericSQLExecutor.executeQuery("SELECT * FROM Inventory WHERE store_id = ?", storeId);

        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Inventory empty");
        } else {
            System.out.println("Inventory of this store:" + "\n");
            System.out.println(inventory + "\n");
        }

        System.out.println("What would you like to do with the inventory?");

        System.out.println("1. Add an item");
        System.out.println("2. Remove an item");
        System.out.println("3. Increase a quantity");
        System.out.println("4. Decrease a quantity");
        System.out.println("5. Cancel");

        System.out.println("Enter your choice: ");
        int choice = Verif.getValidEntry(1, 5, scanner);

        switch (choice) {
            case 1 -> EditItem.add(scanner, storeId);
            case 2 -> EditItem.remove(scanner, storeId);
            case 3 -> EditItem.increase(scanner, storeId, "0", null);
            case 4 -> EditItem.decrease(scanner, storeId, "0", null);
            case 5 -> AdminProfile.reception(scanner);
            default -> System.out.println("Invalid choice");
        }
    }
}
