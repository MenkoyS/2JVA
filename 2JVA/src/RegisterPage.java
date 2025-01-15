import java.util.Scanner;

public class RegisterPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register Page");

        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Enter your password again: ");
        String passwordAgain = scanner.nextLine();

        if (password.equals(passwordAgain)) {
            System.out.println("You have successfully registered");

            System.out.println("Here are your details: ");

            System.out.println("First name: " + firstName);
            System.out.println("Last name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            System.out.println("Would you like to login now ?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Login Page");
                LoginPage.main(args);
            } else if (choice == 2) {
                System.out.println("Goodbye");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Passwords do not match");
        }
    }
}
