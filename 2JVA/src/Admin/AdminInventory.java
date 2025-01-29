package Admin;

import Common.EditItem;
import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class AdminInventory {
    public static void main(Scanner scanner, String storeId) {

        List<GenericSQLExecutor.ResultSetRow> inventory = GenericSQLExecutor.executeQuery("SELECT * FROM Inventory WHERE store_id = ?", storeId);


        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Inventory empty");
            AdminProfile.main(scanner);
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
        int choice = Verif.isEntryValid(1, 5, scanner);

        switch (choice) {
            case 1:
                EditItem.add(scanner, storeId);
                break;
            case 2:
                EditItem.remove(scanner, storeId);
                break;
            case 3:
                EditItem.increase(scanner, storeId, null, null);
                break;
            case 4:
                EditItem.decrease(scanner, storeId, null, null);
                break;
            case 5:
                AdminProfile.main(scanner);
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
