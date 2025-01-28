import java.util.Scanner;

public class ManageStores {
    public static void main(Scanner scanner, String idUser, String userName) {
        System.out.println("Manage Stores");

        System.out.println("1. Add a store");
        System.out.println("2. Remove a store");
        System.out.println("3. Show all stores");
        System.out.println("4. Back to Admin Profile");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                EditStore.AddStore(scanner, idUser, userName);
                break;
            case 2:
                EditStore.RemoveStore(scanner, idUser, userName);
                break;
            case 3:
                ShowStores.main(scanner, idUser, userName);
                break;
            case 4:
                AdminProfile.main(scanner, idUser, userName);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}