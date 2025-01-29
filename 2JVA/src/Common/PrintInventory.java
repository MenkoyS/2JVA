package Common;

import Database.DatabaseUtils;
import Database.GenericSQLExecutor;
import User.UserInventory;

import java.util.List;
import java.util.Scanner;

public class PrintInventory {
    public static void main(Scanner scanner, String idUser, String userName) {

        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE id = ?", idUser);

        System.out.println("User Inventory");

        System.out.println("Choose an item from the inventory: ");

        // For every item in the inventory, print the item name and price
        List<GenericSQLExecutor.ResultSetRow> ItemName = GenericSQLExecutor.executeQuery("SELECT name FROM Inventory WHERE store_id = ?", storeId);
        List<GenericSQLExecutor.ResultSetRow> ItemPrice = GenericSQLExecutor.executeQuery("SELECT price FROM Inventory WHERE store_id = ?", storeId);
        List<GenericSQLExecutor.ResultSetRow> ItemQuantity = GenericSQLExecutor.executeQuery("SELECT quantity FROM Inventory WHERE store_id = ?", storeId);
        List<GenericSQLExecutor.ResultSetRow> ItemId = GenericSQLExecutor.executeQuery("SELECT id FROM Inventory WHERE store_id = ?", storeId);

        assert ItemName != null;
        assert ItemPrice != null;
        assert ItemQuantity != null;
        assert ItemId != null;

        // for every item in the inventory that has the storeId : System.out.println(ItemId + "." + ItemName + " x" + ItemQuantity + " " + ItemPrice + "€");
        for (int i = 0; i < ItemName.size(); i++) {
            System.out.println(ItemId.get(i) + " " + ItemName.get(i) + " " + ItemQuantity.get(i) + " " + ItemPrice.get(i));
        }
        UserInventory.main(scanner, idUser, userName);
    }
}