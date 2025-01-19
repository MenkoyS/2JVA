import java.util.Scanner;

public class CreateNewUserManager {
    public static void AddUserToDatabase(String email, String pseudo, String password) {
        GenericSQLExecutor.executeQuery("INSERT INTO User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)", email, pseudo, password, 1);
    }

    public static void Redirection(Scanner scanner) {
        System.out.println("Do you want to go to the login page ?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // TODO : Call Login Page
                break;
            case 2:
                // TODO : Comeback to profile menu
                break;
            default:
                System.out.println("Invalid choice, returning to the profile menu");
                CreateNewUserManager.Redirection(scanner);
        }
    }
}