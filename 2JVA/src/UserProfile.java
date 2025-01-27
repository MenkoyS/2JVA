import javax.swing.text.View;
import java.util.Scanner;

public class UserProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello User !");

        System.out.println("Welcome to your profile ! ");
        System.out.println("1. See the inventory");
        System.out.println("2. View Profile");
        System.out.println("3. Edit Profile");
        System.out.println("4 Search for a user");
        System.out.println("5. Create a new account");
        System.out.println("6. Logout");
        System.out.println("7. Delete Profile");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Inventory: ");
                break;
            case 2:
                ViewProfile.main(scanner, args);
            case 3:
                System.out.println("Edit Profile: ");
                break;
            case 4:
                System.out.println("Search for a user: ");
                break;
            case 5:
                System.out.println("Create a new account: ");
                break;
            case 6:
                System.out.println("Logout: ");
                break;
            case 7:
                System.out.println("Delete Profile: ");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
