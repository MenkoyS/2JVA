import java.util.List;
import java.util.Scanner;

public class AdminInventory {
    public static void main(Scanner scanner, String storeId, String idUser, String userName) {
        System.out.println(storeId);

        List<GenericSQLExecutor.ResultSetRow> inventory = GenericSQLExecutor.executeQuery("SELECT * FROM Inventory WHERE store_id = ?", storeId);


        if (inventory == null || inventory.isEmpty()) {
            System.out.println("Inventory empty");
            System.exit(1);
        } else {
            System.out.println(inventory);
        }

        System.out.println("What would you like to do with the inventory?");

        System.out.println("1. Add an item");
        System.out.println("2. Remove an item");
        System.out.println("3. Increase a quantity");
        System.out.println("4. Decrease a quantity");
        System.out.println("5. Cancel");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                EditItem.add(scanner, storeId, idUser, userName);
                break;
            case 2:
                EditItem.remove(scanner, storeId, idUser, userName);
                break;
            case 3:
                EditItem.increase(scanner, storeId, idUser, userName);
                break;
            case 4:
                System.out.println("Enter the name of the item you would like to decrease the quantity of: ");
                String itemNameDecrease = scanner.next();
                EditItem.decrease(scanner, storeId, idUser, userName);
                break;
            case 5:
                AdminProfile.main(scanner, idUser, userName);
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
