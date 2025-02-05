package CLI.User;

import CLI.Common.EditItem;
import Database.DatabaseUtils;
import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class UserInventory {
    public static void storeInventory(Scanner scanner, String idUser, String userName) {
        String storeId = getStoreId(idUser);
        if (storeId == null) {
            System.out.println("Error: Store ID not found.");
            return;
        }

        List<GenericSQLExecutor.ResultSetRow> inventory = fetchInventory(storeId);
        displayInventory(inventory);
        handleUserChoice(scanner, storeId, idUser, userName);
    }

    private static String getStoreId(String idUser) {
        return DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM CLI.User WHERE id = ?", idUser);
    }

    private static List<GenericSQLExecutor.ResultSetRow> fetchInventory(String storeId) {
        return GenericSQLExecutor.executeQuery("SELECT * FROM Inventory WHERE store_id = ?", storeId);
    }

    private static void displayInventory(List<GenericSQLExecutor.ResultSetRow> inventory) {
        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Inventory empty");
        } else {
            System.out.println(inventory);
        }
    }

    private static void handleUserChoice(Scanner scanner, String storeId, String idUser, String userName) {
        System.out.println("What would you like to do with the inventory?");
        System.out.println("1. Increase a quantity");
        System.out.println("2. Decrease a quantity");
        System.out.println("3. Go back");

        int choice = Verif.getValidEntry(1, 3, scanner);

        switch (choice) {
            case 1 -> EditItem.increase(scanner, storeId, idUser, userName);
            case 2 -> EditItem.decrease(scanner, storeId, idUser, userName);
            case 3 -> UserProfile.reception(scanner, idUser, userName, false);
            default -> System.out.println("Invalid choice");
        }
    }
}
