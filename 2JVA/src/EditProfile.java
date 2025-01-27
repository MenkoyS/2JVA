import java.util.Scanner;

public class EditProfile {
    public static void main(Scanner scanner, String[] args) {

        System.out.println("Edit Profile: ");

        System.out.println("1. Change pseudo");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Return to User menu");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ChangePseudo.main(scanner, args);
            case 2:
                ChangeEmail.main(scanner, args);
            case 3:
                ChangePassword.main(scanner, args);
            case 4:
                UserProfile.main(args);
            default:
                System.out.println("Invalid choice");
        }


    }
}