import java.util.Scanner;

public class WelcomeMenu {
    public static void main(String[] args) {
        System.out.println("Hello");

        System.out.println("Would you like to login or to register ?");
        System.out.println("1. Login");
        System.out.println("2. Register");

        System.out.println("Enter your choice: ");

        // if the user enters 1 then the program will print "Login"
        // if the user enters 2 then the program will print "Register"

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Login");
        } else if (choice == 2) {
            System.out.println("Register");
        } else {
            System.out.println("Invalid choice");
        }
    }
}
