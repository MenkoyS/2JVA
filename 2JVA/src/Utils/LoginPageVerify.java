package Utils;

import Database.GenericSQLExecutor;
import Menus.GuiMenu;

import java.util.List;
import java.util.Scanner;

public class LoginPageVerify {

    public static void verify(Scanner scanner, String[] userDetails) {

        String email = userDetails[0];
        String password = userDetails[1];

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ? AND password = ?", email, password);

        if (rows != null && !rows.isEmpty()) {
            System.out.println("You have successfully logged in");
            System.out.println("Redirecting you to your profile...");
            Verif.isAdminLogin(email, scanner);
        } else {
            System.out.println("Invalid email or password");
            GuiMenu.main(scanner);
        }

    }
}
