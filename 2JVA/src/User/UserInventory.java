package User;

import Common.EditItem;
import Database.DatabaseUtils;
import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class UserInventory {
    public static void main(Scanner scanner, String idUser, String userName) {
        // TEMPORARY
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE id = ?", idUser);
        List<GenericSQLExecutor.ResultSetRow> inventory = GenericSQLExecutor.executeQuery("SELECT * FROM Inventory WHERE store_id = ?", storeId);

        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Inventory empty");

        } else {
            System.out.println(inventory);
        }
        System.out.println("What would you like to do with the inventory?");
        System.out.println("1. Increase a quantity");
        System.out.println("2. Decrease a quantity");
        System.out.println("3. Go back");

        int choice = Verif.isEntryValid(1, 3, scanner);

        switch (choice) {
            case 1:
                EditItem.increase(scanner, storeId, idUser, userName);
                break;
            case 2:
                EditItem.decrease(scanner, storeId, idUser, userName);
                break;
            case 3:
                UserProfile.main(scanner, idUser, userName);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}