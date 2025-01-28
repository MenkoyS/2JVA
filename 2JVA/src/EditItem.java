import java.util.Scanner;

public class EditItem {
    public static void increase(Scanner scanner, String itemName, String storeId) {
        System.out.println("Enter the quantity you would like to increase by: ");
        int quantityIncrease = scanner.nextInt();
        // Increase the quantity of the item with the given name by the given quantity
        GenericSQLExecutor.executeQuery("UPDATE Inventory SET quantity = quantity + ? WHERE name = ? AND store_id = ?", quantityIncrease, itemName, storeId);

        System.out.println("Quantity increased by " + quantityIncrease);
        System.out.println("New quantity: " + GenericSQLExecutor.executeQuery("SELECT quantity FROM Inventory WHERE name = ? AND store_id = ?", itemName, storeId));
    }
    public static void decrease(Scanner scanner, String itemName, String storeId) {
        System.out.println("Enter the quantity you would like to decrease by: ");
        int quantityDecrease = scanner.nextInt();
        // Decrease the quantity of the item with the given name by the given quantity
        GenericSQLExecutor.executeQuery("UPDATE Inventory SET quantity = quantity - ? WHERE name = ? AND store_id = ?", quantityDecrease, itemName, storeId);

        System.out.println("Quantity decreased by " + quantityDecrease);
        System.out.println("New quantity: " + GenericSQLExecutor.executeQuery("SELECT quantity FROM Inventory WHERE name = ? AND store_id = ?", itemName, storeId));
    }
    public static void add(Scanner scanner, String storeId) {
        System.out.println("Enter the name of the item you would like to add: ");
        String itemName = scanner.next();
        System.out.println("Enter the price of the item you would like to add: ");
        int itemPrice = scanner.nextInt();
        System.out.println("Enter the quantity of the item you would like to add: ");
        int itemQuantity = scanner.nextInt();
        // Add an item with the given name, price, and quantity
        GenericSQLExecutor.executeQuery("INSERT INTO Inventory (name, price, quantity, store_id) VALUES (?, ?, ?, ?)", itemName, itemPrice, itemQuantity, storeId);

        System.out.println("Item added");
    }
    public static void remove(Scanner scanner, String storeId) {
        System.out.println("Enter the name of the item you would like to remove: ");
        String itemNameRemove = scanner.next();

        // Remove the item with the given name
        GenericSQLExecutor.executeQuery("DELETE FROM Inventory WHERE name = ? AND store_id = ?", itemNameRemove, storeId);

        System.out.println("Item removed");
    }
}
