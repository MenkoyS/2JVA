import java.util.List;
import java.util.Scanner;

public class InventorySelection {
    public static void main(Scanner scanner, String idUser, String userName) {
        System.out.println("Inventory Selection");

        System.out.println("From which store do you want to access the inventory?");
        String storeName = scanner.nextLine();

        List<GenericSQLExecutor.ResultSetRow> store = GenericSQLExecutor.executeQuery("SELECT * FROM Store WHERE name = ?", storeName);

        if (store == null || store.isEmpty()) {
            System.out.println("Store not found");
            AdminProfile.main(scanner, idUser, userName);
        } else {
            System.out.println(store);
            String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM Store WHERE name = ?", storeName);
            AdminInventory.main(scanner,storeId, idUser, userName);
        }
    }
}
