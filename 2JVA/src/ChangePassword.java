import java.util.Scanner;

public class ChangePassword {
    public static void main(Scanner scanner, String[] args) {
        int id = 7;
        System.out.print("Enter new password : ");
        scanner.nextLine();
        String choice = scanner.nextLine();
        GenericSQLExecutor.executeQuery("UPDATE User SET password = ? WHERE id = ?", choice, id);
        EditProfile.main(scanner, args);
    }
}
