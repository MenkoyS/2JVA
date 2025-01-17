import java.util.Scanner;

public class AdminProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello Admin !");

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
                System.out.println("Manage the inventory");
                break;
            case 2:
                System.out.println("Manage Users");
                break;
            case 3:
                ManageWhitelist.main(args);
                break;
            case 4:
                System.out.println("Manage Stores");
                break;
            case 5:
                System.out.println("Logout");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
