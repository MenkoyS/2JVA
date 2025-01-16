import java.util.Scanner;

public class ManageWhitelist {
    public static void main(String[] args) {
        System.out.println("Manage Whitelist");

        System.out.println("1. Add to Whitelist");
        System.out.println("2. Remove from Whitelist");
        System.out.println("3. View Whitelist");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the email address: ");
                String email = scanner.nextLine();
                System.out.println("Confirm the email address: ");
                String confirmEmail = scanner.nextLine();
                System.out.println("Enter the store name: ");
                String storeName = scanner.nextLine();
                System.out.println("Confirm the store name: ");
                String confirmStoreName = scanner.nextLine();

                System.out.println("Here are the details: ");
                System.out.println("Email: " + email);
                System.out.println("Store Name: " + storeName);

                System.out.println("Do you want to add this to the whitelist?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int confirmChoice = scanner.nextInt();

                if (confirmChoice == 1) {
                    System.out.println("Added to Whitelist");
                } else if (confirmChoice == 2) {
                    System.out.println("Not added to Whitelist");
                    // TODO : Go back to the beginning of the class
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("Remove from Whitelist");
                break;
            case 3:
                System.out.println("View Whitelist");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}