package Utils;

import Database.GenericSQLExecutor;
import Menus.CliMenu;

import java.util.List;
import java.util.Scanner;

public class LoginPageVerify {

    public static void verify(Scanner scanner, String[] userDetails, boolean isGui) {

        String email = userDetails[0];
        String password = userDetails[1];

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ? AND password = ?", email, password);

        if (rows != null && !rows.isEmpty() && !isGui) {
            System.out.println("You have successfully logged in");
            System.out.println("Redirecting you to your profile...");
            Verif.isAdminLogin(email, scanner, false);
        } else if (rows != null && !rows.isEmpty()) {
            // TODO: Redirect to the user profile GUI
        } else if (rows == null || !isGui) {
            System.out.println("Invalid email or password");
            CliMenu.main(scanner, false);
        } else {
            // CALL GUI
        }
    }
}