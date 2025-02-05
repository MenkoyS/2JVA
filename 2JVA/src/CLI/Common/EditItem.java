package CLI.Common;

import CLI.Admin.AdminInventory;
import Database.GenericSQLExecutor;
import CLI.User.UserInventory;
import Utils.Verif;

import java.util.Scanner;

public class EditItem {
    public static void increase(Scanner scanner, String storeId, String idUser, String userName) {
        System.out.println("Enter the name of the item you would like to increase the quantity of: ");
        String itemNameIncrease = scanner.next();

        System.out.println("Enter the quantity you would like to increase by: ");
        int quantityIncrease = Verif.getValidEntry(1, 49, scanner);

        GenericSQLExecutor.executeQuery("UPDATE Inventory SET quantity = quantity + ? WHERE name = ? AND store_id = ?", quantityIncrease, itemNameIncrease, storeId);

        // Add a verify function here to check if :
        // the item exists in the inventory chosen
        // the quantity does not exceed 50 nor go below 0

        System.out.println("Quantity increased by " + quantityIncrease);
        System.out.println("New quantity: " + GenericSQLExecutor.executeQuery("SELECT quantity FROM Inventory WHERE name = ? AND store_id = ?", itemNameIncrease, storeId));

        Verif.verifyAdmin(scanner, idUser, userName);
    }
    public static void decrease(Scanner scanner, String storeId, String idUser, String userName) {
        System.out.println("Enter the name of the item you would like to decrease the quantity of: ");
        String itemNameDecrease = scanner.next();

        System.out.println("Enter the quantity you would like to decrease by: ");
        int quantityDecrease = Verif.getValidEntry(1, 49, scanner);

        GenericSQLExecutor.executeQuery("UPDATE Inventory SET quantity = quantity - ? WHERE name = ? AND store_id = ?", quantityDecrease, itemNameDecrease, storeId);

        // Add a verify function here to check if :
        // the item exists in the inventory chosen
        // the quantity does not exceed 50 nor go below 0

        System.out.println("Quantity decreased by " + quantityDecrease);
        System.out.println("New quantity: " + GenericSQLExecutor.executeQuery("SELECT quantity FROM Inventory WHERE name = ? AND store_id = ?", itemNameDecrease, storeId));

        UserInventory.storeInventory(scanner, idUser, userName);
    }

    public static void add(Scanner scanner, String storeId) {
        System.out.println("Enter the name of the item you would like to add: ");
        String itemName = scanner.next();

        System.out.println("Enter the price of the item you would like to add: ");
        int itemPrice = Verif.getValidEntry(1, 999, scanner);

        System.out.println("Enter the quantity of the item you would like to add: ");
        int itemQuantity = Verif.getValidEntry(1, 49, scanner);

        GenericSQLExecutor.executeQuery("INSERT INTO Inventory (name, price, quantity, store_id) VALUES (?, ?, ?, ?)", itemName, itemPrice, itemQuantity, storeId);

        System.out.println("Item" + itemName + " added with a price of " + itemPrice + "$" + " and a quantity of " + itemQuantity);

        AdminInventory.manageStoreInventory(scanner, storeId);
    }
    public static void remove(Scanner scanner, String storeId) {
        System.out.println("Enter the name of the item you would like to remove: ");
        String itemNameRemove = scanner.next();

        System.out.println("Are you sure you want to remove " + itemNameRemove + "?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int confirmChoice = Verif.getValidEntry(1, 2, scanner);

        if (confirmChoice == 2) {
            AdminInventory.manageStoreInventory(scanner, storeId);
        }

        GenericSQLExecutor.executeQuery("DELETE FROM Inventory WHERE name = ? AND store_id = ?", itemNameRemove, storeId);

        System.out.println("Item removed");

        AdminInventory.manageStoreInventory(scanner, storeId);
    }
}
