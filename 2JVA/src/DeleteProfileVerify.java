import java.util.List;
import java.util.Scanner;

public class DeleteProfileVerify {
    public static void main(Scanner scanner) {
        System.out.println("Please enter your email to delete your profile: ");
        String email = scanner.next();

        System.out.println("Please enter your password to delete your profile: ");
        String password = scanner.next();

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = '" + email + "' AND password = '" + password + "';");

        if (rows!=null && !rows.isEmpty()) {
            GenericSQLExecutor.executeQuery("DELETE FROM User WHERE email = '" + email + "' AND password = '" + password + "';");
            System.out.println("Profile deleted successfully!");
        } else {
            System.out.println("Invalid password, profile not deleted.");
        }
    }
}
