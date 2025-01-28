import java.util.Scanner;

public class AdminProfile {
    public static void main(Scanner scanner, String idUser, String userName) {

        System.out.println("Hello " + userName + " !");

        System.out.println("Welcome to your profile ! ");
        System.out.println("1. Manage the inventory");
        System.out.println("2. Manage Users");
        System.out.println("3. Manage Whitelist");
        System.out.println("4 Manage Stores");
        System.out.println("5. Logout");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                InventorySelection.main(scanner, idUser, userName);
                break;
            case 2:
                ManageUsers.main(scanner, idUser, userName);
                break;
            case 3:
                ManageWhitelist.main(scanner, idUser, userName);
                break;
            case 4:
                ManageStores.main(scanner, idUser, userName);
                break;
            case 5:
                WelcomeMenu.main(scanner);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
