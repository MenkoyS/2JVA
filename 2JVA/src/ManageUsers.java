import java.util.Scanner;

public class ManageUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Manage Users");

        // make a list of users
        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};

        // give an email to each user
        String[] emails = {"alice@gmail.com", "bob@gmail.com", "charlie@gmail.com", "david@gmail.com", "eve@gmail.com"};

        System.out.println("Search for a user");

        System.out.println("1. Search by name");
        System.out.println("2. Search by email");
        System.out.println("3. Search by store");
        System.out.println("4. Go back");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Search by name");
                System.out.println("Enter the name of the user: ");
                String name = scanner.next();
                for (int i = 0; i < users.length; i++) {
                    if (users[i].equals(name)) {
                        System.out.println("User found: " + users[i] + " with email: " + emails[i]);
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Search by email");
                System.out.println("Enter the email of the user: ");
                String email = scanner.next();
                for (int i = 0; i < emails.length; i++) {
                    if (emails[i].equals(email)) {
                        System.out.println("User found: " + users[i] + " with email: " + emails[i]);
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Search by store");
                System.out.println("Enter the store of the user: ");
                String store = scanner.next();
                for (int i = 0; i < users.length; i++) {
                    if (users[i].equals(store)) {
                        System.out.println("User found: " + users[i] + " with email: " + emails[i]);
                        break;
                    }
                }
                break;
            case 4:
                System.out.println("Go back");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}