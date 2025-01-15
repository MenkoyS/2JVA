import java.util.Scanner;

public class LoginPage {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Login Page");

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("You have successfully logged in");
    }
}
