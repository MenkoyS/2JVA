import java.util.List;
import java.util.Scanner;

public class ChangeEmail {
    public static void main(Scanner scanner, String[] args) {
        int id = 7;
        System.out.print("Enter new email : ");
        scanner.nextLine();
        String choice = scanner.nextLine();
        int isTaken = isEmailAvailable(choice);
        if (isTaken == 0) {
            GenericSQLExecutor.executeQuery("UPDATE User SET email = ? WHERE id = ?", choice, id);
            System.out.println("Email successfully changed");
        }
        else {
            System.out.println("Email already exists");
        }
        EditProfile.main(scanner, args);
    }

    public static int isEmailAvailable(String email) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT email FROM User WHERE email = '" + email + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("EMAIL ALREADY TAKEN");
            return 1;
        } else {
            System.out.println("EMAIL AVAILABLE");
            return 0;
        }
    }
}
