import java.util.Scanner;

public class ManageStores {
    public static void main(String[] args) {
        System.out.println("Manage Stores");

        String[] stores = {"Store 1", "Store 2", "Store 3", "Store 4", "Store 5"};

        System.out.println("1. Add a store");
        System.out.println("2. Remove a store");
        System.out.println("3. Show all stores");
        System.out.println("4. Back to Admin Profile");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Add a store");
                break;
            case 2:
                System.out.println("Remove a store");
                break;
            case 3:
                System.out.println("Show all stores");
                for (String store : stores) {
                    System.out.println(store);
                }
                break;
            case 4:
                System.out.println("Back to Admin Profile");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}