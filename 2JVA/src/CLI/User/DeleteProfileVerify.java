package CLI.User;

import Database.GenericSQLExecutor;
import CLI.Menus.WelcomeMenu;

import java.util.List;
import java.util.Scanner;

public class DeleteProfileVerify {
    public static void deleteUser(Scanner scanner) {
        System.out.println("Please enter your email to delete your profile: ");
        String email = scanner.next();

        System.out.println("Please enter your password to delete your profile: ");
        String password = scanner.next();

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM CLI.User WHERE email = '" + email + "' AND password = '" + password + "';");

        if (rows!=null && !rows.isEmpty()) {
            GenericSQLExecutor.executeQuery("DELETE FROM CLI.User WHERE email = '" + email + "' AND password = '" + password + "';");
            System.out.println("Profile deleted successfully!");

            // Redirect to the login page
            System.out.println("Redirecting to the welcome page...");
            WelcomeMenu.launch(scanner);
        } else {
            System.out.println("Invalid credentials, profile not deleted.");
        }
    }
}
