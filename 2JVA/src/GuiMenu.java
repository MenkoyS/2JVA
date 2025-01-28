import java.util.Scanner;

public class GuiMenu {
    public static void main(Scanner scanner) {

        System.out.println("Would you like to login or to register ?");
        System.out.println("1. Login");
        System.out.println("2. Register");

        System.out.println("Enter your choice: ");


        int choice = scanner.nextInt();

        if (choice == 1) {
            LoginPage.main(scanner);
        } else if (choice == 2) {
            RegisterPage.main(scanner);
        } else {
            System.out.println("Invalid choice");
        }
    }
}