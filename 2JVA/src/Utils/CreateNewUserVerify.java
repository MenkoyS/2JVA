package Utils;

import CLI.Admin.AdminProfile;
import Database.GenericSQLExecutor;

import java.util.List;
import java.util.Scanner;

public class CreateNewUserVerify {
    public static void isWhitelist(String email, Scanner scanner) {

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT email FROM Whitelist WHERE email = '" + email + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("WHITELISTED");
        } else {
            System.out.println("NOT WHITELISTED");
            AdminProfile.reception(scanner);
        }
    }

    public static void isPasswordCorresponding(String password, String confirmPassword, Scanner scanner) {
        if (password.equals(confirmPassword)) {
            System.out.println("PASSWORDS MATCH");
        } else {
            System.out.println("PASSWORDS DO NOT MATCH");
            AdminProfile.reception(scanner);
        }
    }

    public static void isPseudoAvailable(String pseudo, Scanner scanner) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM CLI.User WHERE pseudo = '" + pseudo + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("PSEUDO ALREADY TAKEN");
            AdminProfile.reception(scanner);
        } else {
            System.out.println("PSEUDO AVAILABLE");
        }
    }
}