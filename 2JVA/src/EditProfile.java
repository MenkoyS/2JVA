import java.util.Scanner;

public class EditProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Edit Profile: ");

        System.out.println("1. Change pseudo");
        System.out.println("2. Change email");
        System.out.println("3. Change password");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Change pseudo: ");
                break;
            case 2:
                System.out.println("Change email: ");
                break;
            case 3:
                System.out.println("Contact your administrator to change your password");
                break;
            default:
                System.out.println("Invalid choice");
        }


    }
}