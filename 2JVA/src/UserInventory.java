import java.util.List;
import java.util.Scanner;

public class UserInventory {
    public static void main(Scanner scanner, String storeId) {
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

        System.out.println("Would you like to increase or decrease the quantity of an item?");

        System.out.println("1. Increase");
        System.out.println("2. Decrease");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Which Item would you like to increase the quantity of?");
                String ItemNameIncrease = scanner.next();
                EditItem.increase(scanner, ItemNameIncrease, storeId);
                break;
            case 2:
                System.out.println("Which Item would you like to decrease the quantity of?");
                String ItemNameDecrease = scanner.next();
                EditItem.decrease(scanner, ItemNameDecrease, storeId);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }


    }
}