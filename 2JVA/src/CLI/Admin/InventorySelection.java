package CLI.Admin;

import Database.DatabaseUtils;

import java.util.Scanner;

public class InventorySelection {
    public static void selectInventory(Scanner scanner) {
        System.out.println("Inventory Selection");
        String storeName = getStoreName(scanner);
        String storeId = fetchStoreId(storeName);

        if (storeId == null) {
            System.out.println("Store not found");
            AdminProfile.reception(scanner);
        } else {
            AdminInventory.manageStoreInventory(scanner, storeId);
        }
    }

    private static String getStoreName(Scanner scanner) {
        System.out.println("From which store do you want to access the inventory?");
        scanner.nextLine(); // buffer
        return scanner.nextLine();
    }

    private static String fetchStoreId(String storeName) {
        return DatabaseUtils.fetchSingleColumnValue(
                "SELECT store_id FROM Store WHERE name = ?", storeName);
    }
}