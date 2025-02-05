package Utils;

import Database.GenericSQLExecutor;
import CLI.Menus.CliMenu;
import Swing.UserGUI;
import Swing.WelcomePage;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class LoginPageVerify {

    public static void verify(Scanner scanner, String[] userDetails, boolean isGui) {
        String email = userDetails[0];
        String password = userDetails[1];

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM CLI.User WHERE email = ? AND password = ?", email, password);

        if (rows != null && !rows.isEmpty() && !isGui) {
            System.out.println("You have successfully logged in");
            System.out.println("Redirecting you to your profile...");
            Verif.handleLogin(email, scanner, false);
        } else if (rows != null && !rows.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have successfully logged in as an user");
            UserGUI.main(email, 1200, 800);
        } else if (rows == null || !isGui) {
            System.out.println("Invalid email or password");
            CliMenu.menu(scanner);
        } else {
            WelcomePage.displayWelcomePage(1200, 800);
        }
    }
}