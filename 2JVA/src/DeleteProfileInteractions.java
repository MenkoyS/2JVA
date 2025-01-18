import java.util.Scanner;

public class DeleteProfileInteractions {
    public static void main(Scanner scanner) {

        System.out.println("Are you sure you want to delete your profile? ");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                DeleteProfileVerify.main(scanner);
                break;
            case 2:
                System.out.println("Profile not deleted, returning back to profile");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
