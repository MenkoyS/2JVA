import java.util.Scanner;

public class ManageWhitelist {
    public static void main(Scanner scanner, String[] args) {
        System.out.println("Manage Whitelist");

        System.out.println("1. Add to Whitelist");
        System.out.println("2. Remove from Whitelist");
        System.out.println("3. View Whitelist");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                AddToWhitelist.main(scanner, args);
                break;
            case 2:
                RemoveFromWhitelist.main(scanner, args);
                break;
            case 3:
                ViewWhitelist.main(args);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}
